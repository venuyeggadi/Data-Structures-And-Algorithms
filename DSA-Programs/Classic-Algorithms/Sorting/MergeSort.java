import java.util.Scanner;

class MergeSort
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        sort(a);

        for(int el : a)
            System.out.print(el+" ");
        System.out.println();
    }


    static void sort(int[] a)
    {
        b = new int[a.length];
        mergeSort(a, 0, a.length-1);
    }

    static int[] b;
    static void mergeSort(int[] a, int start, int end)
    {
        if(end - start == 0)
            return;

        int mid=(start+end)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);

        int i=start,j=mid+1,k=start;

        //Merge1
        for (k = start; k <= end; k++)
        {
            if (i > mid)
                b[k] = a[j++];
            else if (j > end )
                b[k] = a[i++];
            else if (a[i] <= a[j])
                b[k] = a[i++];
            else
                b[k] = a[j++];
        }

        //Merge2
        /*while(i<=mid&&j<=end)
        {
            if(a[i]<=a[j])
            {
                b[k]=a[i];
                k++;i++;
            }
            else
            {
                b[k]=a[j];
                j++;k++;
            }
        }

        while(i<=mid)
        {
            b[k]=a[i];
            i++;k++;
        }

        while(j<=end)
        {
            b[k]=a[j];
            k++;j++;
        }*/

        for(i=start;i<=end;i++)
            a[i]=b[i];
    }
}