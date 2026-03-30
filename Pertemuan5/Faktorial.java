public class Faktorial {
    int FaktorialBF(int n){
        int fakto = 1;
        for (int i = 1; i<=n; i++){
            fakto = fakto * i;
        }
        return fakto;
    }
    int FaktorialDC(int n){
        if(n==1){
            return 1;
        }else{
            int fakto = n * FaktorialDC(n-1);
            return fakto;
        }
    }
    int FaktorialBFWhile(int n){
        int i = 1;
        int hasil = 1;
        while(i <= n){
            hasil = hasil * i;
            i++;
        }
        return hasil;
    }
    public Faktorial() {
    }
}
