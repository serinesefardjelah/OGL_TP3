import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    private Matrix matrix;
    private MatrixMathematics matrixMathematics;
    private double result;
    private double[][] arrayOfMatrix;
    @Given(": I have a square matrix M")
    public void iHaveASquareMatrixM(DataTable data) {
        List<List<Double>> rows = data.asLists(Double.class);
        arrayOfMatrix = new double[rows.size()][rows.size()];
        for( int i=0; i<rows.size(); i++){
            for(int j=0; j<rows.size(); j++){
                arrayOfMatrix[i][j] = rows.get(i).get(j);
            }
        }
        matrix = new Matrix(arrayOfMatrix);


        }


    @When(": I calculate its determinant d")
    public void iCalculateItsDeterminantD() throws NoSquareException {
        matrix = new Matrix(arrayOfMatrix);
        result = matrixMathematics.determinant(matrix);
        System.out.println(result);
    }

    @Then(": The determinant should be equal to {double}")
    public void theDeterminantShouldBeEqualTo(double arg0) {
        assertEquals(arg0, result);
    }
}
