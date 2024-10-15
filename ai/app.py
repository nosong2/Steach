import time
import cv2
import dlib
import numpy as np
from flask import Flask, request, jsonify
from imutils import face_utils
from scipy.spatial import distance

app = Flask(__name__)


def eye_aspect_ratio(eye):
    A = distance.euclidean(eye[1], eye[5])
    B = distance.euclidean(eye[2], eye[4])
    C = distance.euclidean(eye[0], eye[3])
    ear = (A + B) / (2.0 * C)
    return ear

thresh = 0.21
frame_check = 20
detect = dlib.get_frontal_face_detector()
predict = dlib.shape_predictor("models/shape_predictor_68_face_landmarks.dat")

(lStart, lEnd) = face_utils.FACIAL_LANDMARKS_68_IDXS["left_eye"]
(rStart, rEnd) = face_utils.FACIAL_LANDMARKS_68_IDXS["right_eye"]


def drowsiness_detection(gray):

    subjects = detect(gray, 0)

    if not subjects:
        print("No subjects detected")
        return -1


    for subject in subjects:
        print("33333")
        shape = predict(gray, subject)
        shape = face_utils.shape_to_np(shape)
        leftEye = shape[lStart:lEnd]
        rightEye = shape[rStart:rEnd]
        leftEAR = eye_aspect_ratio(leftEye)
        rightEAR = eye_aspect_ratio(rightEye)
        ear = (leftEAR + rightEAR) / 2.0
        if ear < thresh:
            print("Drowsy")
            return 1
        else:
            print("Not drowsy")
            return 0


@app.route('/upload', methods=['POST'])
def upload_file():
    t1 = time.process_time()
    if 'file' not in request.files:
        return jsonify({"error": "No file part"}), 400
    file = request.files['file']
    if file.filename == '':
        return jsonify({"error": "No selected file"}), 400

    npimg = np.fromstring(file.read(), np.uint8)
    img = cv2.imdecode(npimg, cv2.IMREAD_COLOR)

    ret = drowsiness_detection(img)

    t2 = time.process_time()
    print("경과시간:" + str((t2-t1)*1000) + "ms")
    return "결과:" + str(ret), 200, {'Content-Type': 'text/plain'}


if __name__ == '__main__':
    app.run(debug=True)