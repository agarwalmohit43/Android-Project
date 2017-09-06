package mantoo.com.mantoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by MOHIT AGARWAL on 12-07-2017.
 */

public class insertdata extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME="mantoo";
    private static final int DATABASE_VERSION=1;

    private static final String CREATE_TABLE="CREATE TABLE duePayments (\n" +
            "    id          TEXT   NOT NULL\n" +
            "                         PRIMARY KEY,\n" +
            "    mantooId    TEXT   NOT NULL,\n" +
            "    partyId     TEXT   NOT NULL,\n" +
            "    amount      DECIMAL(10,5)  NOT NULL\n" +
            "                         DEFAULT 0,\n" +
            "    dueDate     INTEGER  NOT NULL,\n" +
            "             referenceId TEXT,\n" +
            "    balance     DECIMAL(10,5)  NOT NULL\n" +
            "                         DEFAULT (0),\n" +
            "    createdAt   INTEGER ,\n" +
            "    updatedAt   INTEGER ,\n" +
            "    CONSTRAINT parties_foreignkey FOREIGN KEY (\n" +
            "        partyId\n" +
            "    )\n" +
            "    REFERENCES parties (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE firm (\n" +
            "    id        TEXT   PRIMARY KEY\n" +
            "                       NOT NULL,\n" +
            "    name      TEXT   NOT NULL\n" +
            "                       UNIQUE,\n" +
            "    mantooId  TEXT,\n" +
            "    userId    TEXT   NOT NULL,\n" +
            "    createdAt INTEGER ,\n" +
            "    updatedAt INTEGER ,\n" +
            "    CONSTRAINT userId_Foreign FOREIGN KEY (\n" +
            "        userId\n" +
            "    )\n" +
            "    REFERENCES user (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE inventory (\n" +
            "    id              TEXT   PRIMARY KEY\n" +
            "                             NOT NULL\n" +
            "                             UNIQUE,\n" +
            "    mantooId        TEXT   NOT NULL,\n" +
            "    name            TEXT   NOT NULL\n" +
            "                             UNIQUE,\n" +
            "    firmId          TEXT   NOT NULL,\n" +
            "    mantooProductid TEXT,\n" +
            "    tax             DECIMAL(10,5)  NOT NULL,\n" +
            "    gstRate         DECIMAL(10,5)  NOT NULL,\n" +
            "    rate            DECIMAL(10,5)  NOT NULL,\n" +
            "    mrp             DECIMAL(10,5)  NOT NULL,\n" +
            "    purcahsePrice   DECIMAL(10,5)  NOT NULL,\n" +
            "    createdAt       INTEGER ,\n" +
            "    updatedAt       INTEGER ,\n" +
            "    CONSTRAINT firmId_foreign FOREIGN KEY (\n" +
            "        firmId\n" +
            "    )\n" +
            "    REFERENCES firm (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE parties (\n" +
            "    id          TEXT   PRIMARY KEY\n" +
            "                         NOT NULL\n" +
            "                         UNIQUE,\n" +
            "    mantooId    TEXT     NOT NULL,\n" +
            "    name        TEXT   NOT NULL\n" +
            "                         UNIQUE,\n" +
            "    address     TEXT,\n" +
            "    phoneNumber TEXT,\n" +
            "    dueAmount   DECIMAL(10,5)  NOT NULL\n" +
            "                         DEFAULT 0,\n" +
            "    createdAt   INTEGER ,\n" +
            "    updatedAt   INTEGER  \n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE recievedPayments (\n" +
            "    id             TEXT   PRIMARY KEY\n" +
            "                            NOT NULL,\n" +
            "    partyId        TEXT   NOT NULL,\n" +
            "    amount         DECIMAL(10,5)  NOT NULL\n" +
            "                            DEFAULT 0,\n" +
            "    date           DATETIME NOT NULL\n" +
            "                            DEFAULT CURRENT_DATE,\n" +
            "    comment        TEXT   NOT NULL,\n" +
            "    createdAt      INTEGER ,\n" +
            "    updatedAt      INTEGER ,\n" +
            "    recordLocation TEXT   REFERENCES recordLocation (id),\n" +
            "    CONSTRAINT partyid_foreign FOREIGN KEY (\n" +
            "        partyId\n" +
            "    )\n" +
            "    REFERENCES parties (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE recordLocation (\n" +
            "    id           TEXT   PRIMARY KEY,\n" +
            "    latitude     DECIMAL(10,5)  NOT NULL,\n" +
            "    longitude    DECIMAL(10,5)  NOT NULL,\n" +
            "    createdAt    INTEGER ,\n" +
            "    updatedAt    INTEGER ,\n" +
            "    accuracy     DECIMAL(10,5)  NOT NULL,\n" +
            "    errorMessage TEXT   NOT NULL,\n" +
            "    device       TEXT   NOT NULL\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE [transaction] (\n" +
            "    id                 TEXT   PRIMARY KEY\n" +
            "                                NOT NULL,\n" +
            "    txnNumber          DOUBLE   NOT NULL\n" +
            "                                DEFAULT (0),\n" +
            "    partyId            TEXT   NOT NULL,\n" +
            "    firmId             TEXT   NOT NULL,\n" +
            "    Date               DATETIME NOT NULL\n" +
            "                                DEFAULT (CURRENT_DATE),\n" +
            "    amount             DECIMAL(10,5)  NOT NULL\n" +
            "                                DEFAULT (0),\n" +
            "    additionalDiscount DECIMAL(10,5)  DEFAULT (0) \n" +
            "                                NOT NULL,\n" +
            "    comment            TEXT   DEFAULT Nothing\n" +
            "                                NOT NULL,\n" +
            "    recordLocation     TEXT   CONSTRAINT recordLocationxn_foreign REFERENCES recordLocation (id),\n" +
            "    createdAt          INTEGER ,\n" +
            "    updatedAt          INTEGER ,\n" +
            "    CONSTRAINT firmid_firm FOREIGN KEY (\n" +
            "        firmId\n" +
            "    )\n" +
            "    REFERENCES firm (id),\n" +
            "    CONSTRAINT partyId_foreignkey FOREIGN KEY (\n" +
            "        partyId\n" +
            "    )\n" +
            "    REFERENCES parties (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE txnEntry (\n" +
            "    id            TEXT   PRIMARY KEY,\n" +
            "    quantity      INTEGER  DEFAULT (0),\n" +
            "    mrp           DECIMAL(10,5)  DEFAULT (0) \n" +
            "                           NOT NULL,\n" +
            "    rate          DECIMAL(10,5)  NOT NULL\n" +
            "                           DEFAULT (0),\n" +
            "    discount      DECIMAL(10,5)  NOT NULL\n" +
            "                           DEFAULT (0),\n" +
            "    tax           DECIMAL(10,5)  NOT NULL\n" +
            "                           DEFAULT (0),\n" +
            "    amount        DECIMAL(10,5)  NOT NULL\n" +
            "                           DEFAULT (0),\n" +
            "    comment       TEXT   DEFAULT Nothing,\n" +
            "    createdAt     INTEGER ,\n" +
            "    updatedAt     INTEGER ,\n" +
            "    transactionId TEXT   REFERENCES [transaction] (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE user (\n" +
            "    id        TEXT   PRIMARY KEY\n" +
            "                       NOT NULL,\n" +
            "    name      TEXT   NOT NULL,\n" +
            "    email     TEXT   NOT NULL,\n" +
            "    firmId    TEXT   NOT NULL,\n" +
            "    createdAt INTEGER ,\n" +
            "    updatedAt INTEGER ,\n" +
            "    CONSTRAINT firmid_foreign FOREIGN KEY (\n" +
            "        firmId\n" +
            "    )\n" +
            "    REFERENCES firm (id) \n" +
            ");\n" +
            "\n" +
            "CREATE TABLE mohit (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT,Salary DECIMAL(10,5) NOT NULL);";
    private static final String DROP_TABLE="";

    insertdata(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        Toast.makeText(context,"Constructor Called of insertdata",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Message.message(context,"onCreate Called");
        }catch (Exception e){
            //e.printStackTrace();
            Message.message(context,""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            Message.message(context,"onUpgrade Called");
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e){
            Message.message(context,""+e);
        }
    }
}
