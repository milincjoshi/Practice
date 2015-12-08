import java.util.Scanner;
public class Sorting{
  static int[] arr;
  static void exchange(int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  public static void bubbleSort(){
    for(int i=0; i<arr.length;i++){
      for(int j = 0; j< arr.length;j++){
        if(arr[i]>=arr[j]){
          exchange(i,j);
        }
      }//End Inner
    }//End Outer
  }//End bubbleSort

  public static void insertionSort(){
    int n = arr.length;
    for(int k = 1; k<n; k++){
      int j = k;
      int cur = arr[k];
      while(j>0 && arr[j-1]>=cur){
        arr[j] = arr[j-1];
        j--;
      }//End while
      arr[j] = cur;
    }//End for
  }//End insertionSort

  public static void selectionSort(){
    for(int i = 0; i< arr.length - 1; i++){
      int min_index = i;
      for(int j = i; j< arr.length; j++){
        if(arr[j]>=arr[min_index]){
          min_index = j;
        }//End If
      }//End for Inner
      exchange(min_index, i);
    }//End for Outer
  }//End selectionSort

  public static int partition(int start, int pivot){
    int pivotElement = arr[pivot];
    int wall = start-1;
    for(int cur = start; cur< pivot; cur++){
      if(arr[cur]<=pivotElement){
          wall++;
          exchange(wall, cur);
      }//end if
    }//End for
    exchange(wall+1, pivot);
    return wall+1;
  }//End partition

  public static void quickSort(int[] arr, int start, int pivot){
    try{

    if(start<pivot){
      int q = partition(start, pivot);
      quickSort(arr, start, q-1);
      quickSort(arr, q+1, pivot);
    }
  }
  catch(Exception ex){ex.printStackTrace();}

  }
  public static void merge(int[] arr, int l, int m, int r){
    int n1 = m-l+1;
    int n2 = r - m;

    //create new arrays
    int[] L = new int[n1];
    int[] R = new int[n2];

    //Assigning values to new arrays
    for(int i = 0; i<n1; i++){
      L[i] = arr[l+i];
    }
    for(int j = 0; j<n2; j++){
      R[j] = arr[m+j+1];
    }
    //End assigning values

    //Comparing and merging
    int i=0, j=0, k=l;
    while(i<n1 && j<n2 ){
      if(L[i]<= R[j]){
        arr[k] = L[i];
        i++;
      }//End If
      else{
        arr[k] = R[j];
        j++;
      }//End else
      k++;
    }//end While

    //Copy remaining elements
    while(i<n1){arr[k] = L[i];i++;k++;}
    while(j<n2){arr[k] = R[j];j++;k++;}

  }
  public static void mergeSort(int[] arr, int l, int r){
    if(l<r){
      int mid = (l+r)/2;
      mergeSort(arr, l, mid);
      mergeSort(arr, mid+1, r);
      merge(arr, l, mid, r);
    }//End if
  }

  public static void main(String[] args){
    arr = new int[]{1,7,3,0,2,6,5,2};

    System.out.println("Array Value before");

    for(int i = 0; i< arr.length; i++){
      System.out.print(arr[i]+",");
    }
    System.out.println("\n");
    System.out.println("Use values from 1 to 5 for following cases");
    System.out.println("1. Bubble Sort");
    System.out.println("2. Insertion Sort");
    System.out.println("3. Selection Sort");
    System.out.println("4. Quick Sort");
    System.out.println("5. Merge Sort");

    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    switch(i){
      case 1:
        System.out.println("You selected BubbleSort");
        bubbleSort();
        break;
      case 2:
        System.out.println("You selected insertion Sort");
        insertionSort();
        break;
      case 3:
        System.out.println("You selected SelectedSort");
        selectionSort();
        break;
      case 4:
        System.out.println("You selected Quick ort");
        quickSort(arr, 0, arr.length-1);
        break;
      case 5:
        System.out.println("You selected MergeSort");
        mergeSort(arr, 0, arr.length-1);
        break;
    }//end switch

    System.out.println("Array Value after");

    for(int k = 0; k< arr.length; k++){
      System.out.print(arr[k]+",");
    }

  }//end main
}//end class
