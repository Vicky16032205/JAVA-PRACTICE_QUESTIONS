public class setMarixZero {

    static int[][] matZero(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        boolean row = false;
        boolean column = false;
        
        // checking for elements that are zero in the 2-d matrix.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    if(i == 0) row = true;
                    if(j== 0) column = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // setting row to zeroes if any element in that row is zero.
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // now for the initial row , we do it by doing this :
        if(row){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }

        // same doing for the column.
        if(column){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }

        // returninig the matrix.
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{7,9,13},{4,21,1}};
        matZero(matrix);
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
        }
    }
}