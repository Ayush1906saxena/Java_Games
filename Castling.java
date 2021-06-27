package Chess;

class Castling
{
    static boolean detect()
    {
        int cd=Va.bc.c-Va.mbc.c;
        if(Math.abs(cd)==2)
        {
            swap(cd);
            return true;
        }
        return false;
    }
    static void swap(int cd)
    {
        if(Va.pln==0)
        {
            set(7,cd);
            Va.p1castl=false;
        }
        else if(Va.pln==1)
        {
            set(0,cd);
            Va.p2castl=false;
        }
    }
    static void set(int r,int cd)
    {
        Va.mbc.setIcon(Va.bc.getIcon());
        if(cd==-2)
        {
            reset(r,Va.bc.c+1,7);
        }
        else
        {
            reset(r,Va.bc.c-1,0);
        }
        Va.bc.setIcon(null);
        Va.bc.ei=0;
        Va.bc.pi=-1;
        Va.mbc.pi=Va.pln;
        Va.mbc.ei=5;
        Va.kp[Va.pln]=Va.mbc;
        Va.lblturn[Va.pln].setText("");
        Va.pln=Va.getPn();
        Va.lblturn[Va.pln].setText("It's your turn...");
        Va.chess.box.dehighlight();
        Va.bc=Va.mbc=null;
    }
    static void reset(int r,int c,int oc)
    {
        Va.bt[r][c].setIcon(Va.bt[r][oc].getIcon());
        Va.bt[r][oc].setIcon(null);
        Va.bt[r][oc].ei=0;
        Va.bt[r][oc].pi=-1;
        Va.bt[r][c].ei=1;
        Va.bt[r][c].pi=Va.pln;
    }
}

