package edu.illinois.cs.cs125.spring2019.mp1.lib;


/** Javadoc comment thing. */
public class Transform {
    /**
     * maximum value.
     */
    public static final int MAXVALUE = 255;

    /**
     * Expand in the horizontal axis around the image center.
     *
     * @param amount        these r words
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] expandHorizontal(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] returnImage = RGBAPixel.copyArray(originalImage);
        int shift = (originalImage.length * amount - originalImage.length) / 2;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                returnImage[i][j] = originalImage[((shift + i) / amount) % originalImage.length][j];
            }
        }
        return returnImage;
    }

    /**
     * Expand in the vertical axis around the image center.
     *
     * @param amount        these r words
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] expandVertical(final RGBAPixel[][] originalImage, final int amount) {
        RGBAPixel[][] returnImage = RGBAPixel.copyArray(originalImage);
        int move = (originalImage[0].length * amount - originalImage[0].length) / 2;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                returnImage[i][j] = originalImage[i][((move + j) / amount) % originalImage[i].length];
            }
        }
        return returnImage;
    }

    /**
     * Flip the image on the horizontal axis across its center.
     *
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] flipHorizontal(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] returnImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                returnImage[i][j] = originalImage[originalImage[i].length - 1 - i][j];
            }
        }
        return returnImage;
    }
    /**
     * Flip the image on the vertical axis across its center.
     *
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] flipVertical(final RGBAPixel[][] originalImage) {
        return null;
    }


    /**
     * Remove a green screen mask from an image.
     *
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] greenScreen(final RGBAPixel[][] originalImage) {
        RGBAPixel[][] returnImage = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                if (originalImage[i][j].getGreen() == MAXVALUE) {
                    returnImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    returnImage[i][j] = originalImage[i][j];
                }
            }
        }
        return returnImage;
    }


    /**
     * Rotate the image left by 90 degrees around its center.
     *
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] rotateLeft(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     *
     * @param originalImage these r also words
     * @return the expanded image
     */
    public static RGBAPixel[][] rotateRight(final RGBAPixel[][] originalImage) {
        return null;
    }

    /**
     * Shift the image down by the specified amount.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shiftDown(final RGBAPixel[][] originalImage,
                                          final int amount) {
        return shiftUp(originalImage, amount * -1);
    }

    /**
     * Shift the image left by the specified amount.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shiftLeft(final RGBAPixel[][] originalImage,
                                          final int amount) {
        RGBAPixel[][] returnImage = RGBAPixel.copyArray(originalImage);
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if (i >= originalImage.length - amount || i + amount < 0) {
                    returnImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    returnImage[i][j] = originalImage[i + amount][j];
                }
            }
        }
        return returnImage;
    }

    /**
     * Shift the image right by the specified amount.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage,
                                           final int amount) {
        return shiftLeft(originalImage, amount * -1);
    }


    /**
     * Shift the image up by the specified amount.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shiftUp(final RGBAPixel[][] originalImage,
                                        final int amount) {
        RGBAPixel[][] returnImage = RGBAPixel.copyArray(originalImage);
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if (j >= originalImage[i].length - amount || j + amount < 0) {
                    returnImage[i][j] = RGBAPixel.getFillValue();
                } else {
                    returnImage[i][j] = originalImage[i][j + amount];
                }
            }
        }
        return returnImage;
    }


    /**
     * Shrink in the horizontal axis around the image center.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shrinkHorizontal(final RGBAPixel[][] originalImage,
                                                 final int amount) {
        return null;
    }

    /**
     * Shrink in the vertical axis around the image center.
     *
     * @param originalImage these r also words
     * @param amount        these r words
     * @return the expanded image
     */
    public static RGBAPixel[][] shrinkVertical(final RGBAPixel[][] originalImage,
                                               final int amount) {
        return null;
    }

}
