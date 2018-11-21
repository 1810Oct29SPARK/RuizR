public class GroupTemplate {
	public static void main(String[] args){
		int[] array = {2,4,5,1,3,1}; 
		theQuestion(array); 
	}

	public static void theQuestion(int[] array){
		for (int i=0; i<array.length; i++){
		for (int k=(i+1); k<array.length; k++){
		int temp; 
			if (array[i]>array[k]){
				temp = array[i]; 
				array[i] = array[k]; 
				array[k] = temp; 
			}
		}	
	}

	for(int i=0; i<array.length; i++){
		System.out.println(array[i]);
	}
	
	}
}
