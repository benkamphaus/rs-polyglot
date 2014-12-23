rs-polyglot
===========

Remote sensing algorithms and workflows in multiple languages.

Basics
======
Remote sensing workflows are centered around image cubes. Image cubes consist
of a stack of images, where an image is a 2D array or matrix, and an image
cube is a series of these 2D arrays. The image cube is traversed by the X, Y,
or Z dimension where X and Y are spatial coordinates and the Z axis corresponds
to the spectral dimension of the data. Applying matching algorithms, filtering,
etc. using the spectral dimension of the data while using the ability to locate
pixels geospatially by X, Y coordinates, or to apply texture algorithms, etc.
results in a mix of spatial analysis and spectroscopy. The union of these
techniques is the basis of remote sensing science.
