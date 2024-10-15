# STEACH AI

A focus detection API server runs on Python Flask.
Specially developed for an online tutoring service.

# Description

Once an image is uploaded from the client-side via POST, the server returns one of -1, 0, or 1.
-1 means a tutee has not been found on camera.
0 means a tutee is not drowsy.
1 means a tutee is drowsy.

* A client-side demo HTML is included (Which downsizes an image to 480p before upload)


# References
- [Italo José](https://github.com/italojs/facial-landmarks-recognition/blob/master/shape_predictor_68_face_landmarks.dat)
- [Akshay Bahadur](https://github.com/akshaybahadur21/Drowsiness_Detection)
- [Adrian Rosebrock @ PyImageSearch Blog](https://pyimagesearch.com/2017/05/08/drowsiness-detection-opencv/)

