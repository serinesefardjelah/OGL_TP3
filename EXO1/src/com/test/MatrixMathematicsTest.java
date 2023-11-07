package com.test;

import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMathematicsTest {

    @Test
    void determinant_exception() throws NoSquareException  {
        double[][] matrix1 = {
                {2.0, 1.0, 3.0},
                {0.0, 2.0, 1.0}
        };
        Matrix matrix2 = new Matrix(matrix1);

        NoSquareException exception = assertThrows(NoSquareException.class, () -> {
            MatrixMathematics.determinant(matrix2);
        });

        assertEquals("matrix needs to be square.", exception.getMessage());

    }

    @Test
    void determinant() throws NoSquareException  {
        double[][] matrix1 = {
                {2.0, 0.0, 0.0},
                {0.0, 2.0, 0.0},
                {0.0, 0.0, 3.0}
        };
        Matrix matrix2 = new Matrix(matrix1);



        assertEquals(12.0, MatrixMathematics.determinant(matrix2));

    }
    @Test
    void determinant1D() throws NoSquareException  {
        double[][] matrix1 = {
                {2.0}
        };
        Matrix matrix2 = new Matrix(matrix1);



        assertEquals(2.0, MatrixMathematics.determinant(matrix2));

    }



    @Test
    void createSubMatrix() {
        double[][] matrix1 = {
                {2.0, 0.0, 0.0},
                {0.0, 2.0, 0.0},
                {0.0, 0.0, 3.0}
        };
        double[][] sub_matrix1 = {

                { 2.0, 0.0},
                { 0.0, 3.0}
        };
        Matrix matrix2 = new Matrix(matrix1);
        Matrix sub_matrix2 = new Matrix(sub_matrix1);
        assertArrayEquals(sub_matrix2.getValues(), MatrixMathematics.createSubMatrix(matrix2, 0, 0).getValues() );

    }
}