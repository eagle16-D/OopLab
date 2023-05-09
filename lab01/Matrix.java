<<<<<<< HEAD
package lab1;
=======
package lab01;
>>>>>>> 5b8f20e33920b944e220cf0f81058f92b741fdae

public class Matrix {
	
	public static int[][] add(int mat1[][] ,int mat2[][]){
		
		//check size
		try {
			if(mat1[0].length != mat2[0].length) {
				throw new Exception("Error collumn size");
			}
			if(mat1.length != mat2.length) {
				throw new Exception("Error row size");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int cols = mat1[0].length;
		int rows = mat1.length; 
		int res_mat[][] = new int[rows][cols];
		
		for(int i = 0; i < mat1.length; i++) {
			for(int j = 0; j < mat1[0].length; j++) {
				res_mat[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return res_mat;
	}
	
	public static void main(String[] args) {
		int mat1[][] = {{1,2},{3,4}};
		int mat2[][] = {{5,6},{7,8}};
		int res[][];
		res = add(mat1,mat2);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
