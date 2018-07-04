package pack.versione_1;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GestionaleDB.db";
    public static final String TABLE1_NAME = "t_serra";
    public static final String TABLE2_NAME = "sgrondo";


    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase ();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +TABLE1_NAME +
                "(nome_serra varchar(20) primary key,"+
                "zona varchar(20) not null,"+
                "m2 int not null, " +
                "coltura varchar(20) not null," +
                "varieta varchar(20) not null," +
                "piante_m2 int not null," +
                "data_trapianto date not null," +
                "litri_ora_entrata real  not null," +
                "litri_ora_sgrondo real not null," +
                "target_ec int not null)"
        );
        db.execSQL(     "create table " +TABLE2_NAME +
                        "(nome_serra varchar(20) not null,"+
                        "data date not null,"+
                        "acqua_entrata int not null, " +
                        "EC_acqua_entrata int not null," +
                        "acqua_sgrondo int not null," +
                        "EC_acqua_sgrondo int not null," +
                        "primary key(nome_serra,data)," +
                        "foreign key(nome_serra) references serra)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2_NAME);
        onCreate(db);
    }
}
