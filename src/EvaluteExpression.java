public class EvaluteExpression {

    public static int evalRPN(String[] tokens) {

        int length = tokens.length;

        String[] NumberSrtack = new String[length];
        String[] OperationSatack = new String[length];
        int numberPointer = -1;
        int operationPointer = -1;

        for(int i = 0;i<length;i++){
            if(tokens[i].matches("[0-9]+|^-[0-9]+")){
                NumberSrtack[++numberPointer] = tokens[i];
                System.out.println(tokens[i]);
            }else {
                if(operationPointer!=-1){
                    if(justify(tokens[i],OperationSatack[operationPointer])){
                        String a = NumberSrtack[numberPointer--];
                        String b = NumberSrtack[numberPointer--];
                        int resul = calu(Integer.valueOf(a),Integer.valueOf(b),tokens[i]);
                        NumberSrtack[++numberPointer] = String.valueOf(resul);
                    }else {
                        String a = NumberSrtack[numberPointer--];
                        String b = NumberSrtack[numberPointer--];
                        int resul = calu(Integer.valueOf(a),Integer.valueOf(b),OperationSatack[operationPointer--]);
                        NumberSrtack[++numberPointer] = String.valueOf(resul);
                        OperationSatack[++operationPointer] = tokens[i];

                    }

                }else {
                    String a = NumberSrtack[numberPointer--];
                    String b = NumberSrtack[numberPointer--];
                    int resul = calu(Integer.valueOf(a),Integer.valueOf(b),tokens[i]);
                    NumberSrtack[++numberPointer] = String.valueOf(resul);
                }
            }
        }



        return Integer.valueOf(NumberSrtack[numberPointer]);
    }

    public static int calu(int a,int b,String operation){
        if(operation .equals("+")){
            return a+b;

        }else if(operation.equals("-")){
            return b-a;
        }else if(operation.equals("*")){
            return a*b;
        }else {
            return b/a;
        }

    }

    public static boolean justify(String s1,String s2){
        int a = check(s1);
        int b = check(s2);

        return a>=b;
    }

    public static int check(String s){
        if(s.equals("+")||s.equals("-")){
            return 1;
        }

        return 2;
    }

    public static void main(String[] args){
        String[] s = {"0","3","/"};
        System.out.println(evalRPN(s));
    }
}
