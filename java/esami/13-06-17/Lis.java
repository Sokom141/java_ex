import java.util.ArrayList;

class Lis{

  public static void main(String[] args){
    IntSList vet = new IntSList();
    int[] numeri = new int[] {2, 49, 7, 9, 6};
    for (int i=0; i<numeri.length; i++){
      vet = vet.cons(numeri[i]);
    }
    System.out.println(vet);
    System.out.println(lis(vet));
    
  }
  
  public static IntSList lis( IntSList s ) {
    int len = s.length();
    IntSList[][] mem = new IntSList[len+1][len+1];
    for(int i=0; i<=len; i++){
      for(int j=0; j<=len; j++){
        mem[i][j] = IntSList.NULL_INTLIST;
      }
    }
    return lisRec( s, 0, mem);
  }
  
  public static IntSList lisRec( IntSList s, int t, IntSList[][] cache) {
    int len = s.length();
    if (cache[len][t] == IntSList.NULL_INTLIST){
      if ( s.isNull() ) {
        return new IntSList();
      } else if ( s.car() <= t ) {
        return lisRec( s.cdr(), t, cache );
      } else {
        return longer( new IntSList( s.car(), lisRec( s.cdr(), s.car(), cache ) ),
                      lisRec( s.cdr(), t, cache )
                     );
      }
    }
    return cache[len][t];
  }
  
  public static IntSList longer( IntSList u, IntSList v ) {
    if ( u.length() < v.length() ) {
      return v;
    } else {
      return u;
    }
  }
}