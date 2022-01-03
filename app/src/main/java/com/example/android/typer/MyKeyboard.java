package com.example.android.typer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {

    // constructors
    public MyKeyboard(Context context) {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // keyboard keys (buttons)
    private TextView mButton1; private TextView a; private TextView b; private TextView c; private TextView d;
    private TextView mButton2; private TextView e; private TextView f; private TextView g; private TextView h;
    private TextView mButton3; private TextView i; private TextView j; private TextView k; private TextView l;
    private TextView mButton4; private TextView m; private TextView n; private TextView o; private TextView p;
    private TextView mButton5; private TextView q; private TextView r; private TextView s; private TextView t;
    private TextView mButton6; private TextView u; private TextView v; private TextView w; private TextView x;
    private TextView mButton7; private TextView y; private TextView z; private TextView comma; private TextView fullstop;
    private TextView mButton8; private TextView excl; private TextView space;
    private TextView mButton9;
    private TextView mButton0;
    private TextView mButtonDelete;
    private TextView mButtonEnter;

    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        mButton1 = (TextView) findViewById(R.id.button_1); a = (TextView) findViewById(R.id.a_tv);
        mButton2 = (TextView) findViewById(R.id.button_2); b = (TextView) findViewById(R.id.b_tv);
        mButton3 = (TextView) findViewById(R.id.button_3); c = (TextView) findViewById(R.id.c_tv);
        mButton4 = (TextView) findViewById(R.id.button_4); d = (TextView) findViewById(R.id.d_tv);
        mButton5 = (TextView) findViewById(R.id.button_5); e = (TextView) findViewById(R.id.e_tv);
        mButton6 = (TextView) findViewById(R.id.button_6); f = (TextView) findViewById(R.id.f_tv);
        mButton7 = (TextView) findViewById(R.id.button_7); g = (TextView) findViewById(R.id.g_tv);
        mButton8 = (TextView) findViewById(R.id.button_8); h = (TextView) findViewById(R.id.h_tv);
        mButton9 = (TextView) findViewById(R.id.button_9); i = (TextView) findViewById(R.id.i_tv);
        mButton0 = (TextView) findViewById(R.id.button_0); j = (TextView) findViewById(R.id.j_tv);
        mButtonDelete = (TextView) findViewById(R.id.back_tv); k = (TextView) findViewById(R.id.k_tv);
        mButtonEnter = (TextView) findViewById(R.id.done); l = (TextView) findViewById(R.id.l_tv);

        m = (TextView) findViewById(R.id.m_tv); t = (TextView) findViewById(R.id.t_tv);
        n = (TextView) findViewById(R.id.n_tv); u = (TextView) findViewById(R.id.u_tv);
        o = (TextView) findViewById(R.id.o_tv); v = (TextView) findViewById(R.id.v_tv);
        p = (TextView) findViewById(R.id.p_tv); w = (TextView) findViewById(R.id.w_tv);
        q = (TextView) findViewById(R.id.q_tv); x = (TextView) findViewById(R.id.x_tv);
        r = (TextView) findViewById(R.id.r_tv); y = (TextView) findViewById(R.id.y_tv);
        s = (TextView) findViewById(R.id.s_tv); z = (TextView) findViewById(R.id.z_tv);
        fullstop = (TextView) findViewById(R.id.full_stop); comma = (TextView) findViewById(R.id.comma);
        excl = (TextView) findViewById(R.id.excl_tv); space = (TextView) findViewById(R.id.space);
        // set button click listeners
        mButton1.setOnClickListener(this); a.setOnClickListener(this); m.setOnClickListener(this); y.setOnClickListener(this);
        mButton2.setOnClickListener(this); b.setOnClickListener(this); n.setOnClickListener(this); z.setOnClickListener(this);
        mButton3.setOnClickListener(this); c.setOnClickListener(this); o.setOnClickListener(this); fullstop.setOnClickListener(this);
        mButton4.setOnClickListener(this); d.setOnClickListener(this); p.setOnClickListener(this); comma.setOnClickListener(this);
        mButton5.setOnClickListener(this); e.setOnClickListener(this); q.setOnClickListener(this); excl.setOnClickListener(this);
        mButton6.setOnClickListener(this); f.setOnClickListener(this); r.setOnClickListener(this); space.setOnClickListener(this);
        mButton7.setOnClickListener(this); g.setOnClickListener(this); s.setOnClickListener(this);
        mButton8.setOnClickListener(this); h.setOnClickListener(this); t.setOnClickListener(this);
        mButton9.setOnClickListener(this); i.setOnClickListener(this); u.setOnClickListener(this);
        mButton0.setOnClickListener(this); j.setOnClickListener(this); v.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this); k.setOnClickListener(this); w.setOnClickListener(this);
        mButtonEnter.setOnClickListener(this); l.setOnClickListener(this); x.setOnClickListener(this);

        // map buttons IDs to input strings
        keyValues.put(R.id.button_1, "1"); keyValues.put(R.id.a_tv,"a"); keyValues.put(R.id.l_tv,"l"); keyValues.put(R.id.w_tv,"w");
        keyValues.put(R.id.button_2, "2"); keyValues.put(R.id.b_tv,"b"); keyValues.put(R.id.m_tv,"m"); keyValues.put(R.id.x_tv,"x");
        keyValues.put(R.id.button_3, "3"); keyValues.put(R.id.c_tv,"c"); keyValues.put(R.id.n_tv,"n"); keyValues.put(R.id.y_tv,"y");
        keyValues.put(R.id.button_4, "4"); keyValues.put(R.id.d_tv,"d"); keyValues.put(R.id.o_tv,"o"); keyValues.put(R.id.z_tv,"z");
        keyValues.put(R.id.button_5, "5"); keyValues.put(R.id.e_tv,"e"); keyValues.put(R.id.p_tv,"p"); keyValues.put(R.id.comma,",");
        keyValues.put(R.id.button_6, "6"); keyValues.put(R.id.f_tv,"f"); keyValues.put(R.id.q_tv,"q"); keyValues.put(R.id.full_stop,".");
        keyValues.put(R.id.button_7, "7"); keyValues.put(R.id.g_tv,"g"); keyValues.put(R.id.r_tv,"r"); keyValues.put(R.id.excl_tv,"!");
        keyValues.put(R.id.button_8, "8"); keyValues.put(R.id.h_tv,"h"); keyValues.put(R.id.s_tv,"s"); keyValues.put(R.id.space," ");
        keyValues.put(R.id.button_9, "9"); keyValues.put(R.id.i_tv,"i"); keyValues.put(R.id.t_tv,"t");
        keyValues.put(R.id.button_0, "0"); keyValues.put(R.id.j_tv,"j"); keyValues.put(R.id.u_tv,"u");
        keyValues.put(R.id.done, "\n"); keyValues.put(R.id.k_tv,"k"); keyValues.put(R.id.v_tv,"v");
    }

    @Override
    public void onClick(View v) {

        // do nothing if the InputConnection has not been set yet
        if (inputConnection == null) return;

        // Delete text or input key value
        // All communication goes through the InputConnection
        if (v.getId() == R.id.back_tv) {
            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(v.getId());
            inputConnection.commitText(value, 1);
        }
    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }
}