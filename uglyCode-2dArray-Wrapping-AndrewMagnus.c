#include <stdio.h>

void exit(int);

int main()
{
  int A[100][100];
  int B[100][100];
  //fprintf(stderr, "%s\n", "here");

        FILE *f = fopen("input.txt", "r");
        for(int row = 0; row < 100; row++)
        {
          //fprintf(stderr, "%i\n", row);
                for (int col = 0; col < 100; col++)
                {

                        A[row][col] = (fgetc(f) == '*');
                }
                fgetc(f);//removes the 100ths
        }
        //fprintf(stderr, "%s\n", "here");
        fclose(f);

        for (int i = 0; i < 1001; i++) {
                if (i % 10 == 0) printf("Step %d\n", i);
                for (int a = 0; a < 100; a++) {
                        for (int b = 0; b < 100; b++) {
                                int c = 0;
                                if (i % 2) {
//					    printf("#10\n");

                                        //left top corner
                                        if(a == 0 && b == 0) c+= B[99][99];//true
                                        if(a == 0 && b > 0)  c+= B[99][b-1];//f
                                        if(a > 0 && b == 0) c+= B[a-1][99];//f
                                        if(a > 0 && b > 0) c+= B[a-1][b-1];//f

                                        //left of center
                                        if(a == 0) c+= B[99][b]; //true
                                        if(a > 0) c+= B[a-1][b];//false

                                        //left bottom corner
                                        if(a == 0 && b == 99) c+= B[99][0]; //f
                                        if(a == 0 && b < 99)  c+= B[99][b+1];//t
                                        if(a > 0 && b == 99) c+= B[a-1][0];//f
                                        if(a > 0 && b < 99) c+= B[a-1][b+1];//f

                                        //above
                                        if(b == 0) c+= B[a][99];//t
                                        if(b > 0)  c+= B[a][b-1];//f

                                        //below
                                        if(b == 99) c+= B[a][0];//f
                                        if(b < 99)  c+= B[a][b+1];//t

                                        //top right
                                        if(a == 99 && b == 0) c+= B[0][99];//f
                                        if(a == 99 && b > 0)  c+= B[0][b-1];//f
                                        if(a < 99 && b == 0) c+= B[a+1][99];//t
                                        if(a < 99 && b > 0) c+= B[a+1][b-1];//f

                                        //one right
                                        if(a == 99) c+= B[0][b];//f
                                        if(a < 99) c+= B[a+1][b];//t

                                        //lower right
                                        if(a == 99 && b == 99) c+= B[0][0];//f
                                        if(a == 99 && b < 99)  c+= B[0][b+1];//f
                                        if(a < 99 && b == 99) c+= B[a+1][0];//f
                                        if(a < 99 && b < 99) c+= B[a+1][b+1];//t

                                        /*if (a > 0)// if row is past 0 we can check safely the left side
                                        {
                                                if (b > 0) c += B[a-1][b-1]; //one abov left corner
                                                c +=  B[a-1][b]; //one left
                                                if (b < 99) c += B[a-1][b+1]; //one below left corner
                                        }
                                        if (b > 0) c +=  B[a][b-1]; //one above
                                        if (b < 99) c += B[a][b+1]; //one below
                                        if (a < 99)//we can safely check the right side
                                        {
                                                if (b > 0) c +=  B[a+1][b-1]; //right corner
                                                c += B[a+1][b];//one right
                                                if (b < 99) c += B[a+1][b+1]; //bottom right
                                        }*/
                                      //  fprintf(stderr, "%i\n", c);
                                        A[a][b] = (c == 3) || ((B[a][b] == 1) && c >= 2 && c <= 3);
                                }
                                else {
                                  //left top corner
                                  if(a == 0 && b == 0) c+= A[99][99];
                                  if(a == 0 && b > 0)  c+= A[99][b-1];
                                  if(a > 0 && b == 0) c+= A[a-1][99];
                                  if(a > 0 && b > 0) c+= A[a-1][b-1];

                                  //left of center
                                  if(a == 0) c+= A[99][b];
                                  if(a > 0) c+= A[a-1][b];

                                  //left bottom corner
                                  if(a == 0 && b == 99) c+= A[99][0];
                                  if(a == 0 && b < 99)  c+= A[99][b+1];
                                  if(a > 0 && b == 99) c+= A[a-1][0];
                                  if(a > 0 && b < 99) c+= A[a-1][b+1];

                                  //above
                                  if(b == 0) c+= A[a][99];
                                  if(b > 0)  c+= A[a][b-1];

                                  //below
                                  if(b == 99) c+= A[a][0];
                                  if(b < 99)  c+= A[a][b+1];

                                  //top right
                                  if(a == 99 && b == 0) c+= A[0][99];
                                  if(a == 99 && b > 0)  c+= A[0][b-1];
                                  if(a < 99 && b == 0) c+= A[a+1][99];
                                  if(a < 99 && b > 0) c+= A[a+1][b-1];

                                  //one right
                                  if(a == 99) c+= A[0][b];
                                  if(a < 99) c+= A[a+1][b];

                                  //lower right
                                  if(a == 99 && b == 99) c+= A[0][0];
                                  if(a == 99 && b < 99)  c+= A[0][b+1];
                                  if(a < 99 && b == 99) c+= A[a+1][0];
                                  if(a < 99 && b < 99) c+= A[a+1][b+1];
                                        /*if (a > 0)                                  // if row is past 0 we can check safely the left side
                                        {
                                                if (b > 0) c += A[a-1][b-1];                                   //one abov left corner
                                                c +=  A[a-1][b];                                   //one left
                                                if (b < 99) c += A[a-1][b+1];                                  //one below left corner
                                        }
                                        if (b > 0) c +=  A[a][b-1];                                  //one above
                                        if (b < 99) c += A[a][b+1];                                  //one below
                                        if (a < 99)                                  //we can safely check the right side
                                        {
                                                if (b > 0) c +=  A[a+1][b-1];                                  //right corner
                                                c += A[a+1][b];                                  //one right
                                                if (b < 99) c += A[a+1][b+1];                                  //bottom right
                                        }*/
                                        //fprintf(stderr, "%i\n", c);
                                        B[a][b] = (c == 3) || ((A[a][b] == 1) && c >= 2 && c <= 3);
                                }
                        }
                }
        }


        f = fopen("output.txt", "w");
        for(int row=0; row <100; row++)
        {
                for (int col = 0; col < 100; col++)
                {
                        fputc(B[row][col] == 1 ? '*' : ' ', f);
                }
                fputc('\n', f);//add newlines at the end of each row
        }
        //fputc('\n', f);// might need ot remove
        fclose(f);
}
