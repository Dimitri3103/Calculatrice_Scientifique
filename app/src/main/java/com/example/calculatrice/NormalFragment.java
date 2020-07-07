package com.example.calculatrice;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NormalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NormalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NormalFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private TextView input;
    private TextView signBox;
    private String sign;
    private String value1;
    private boolean hasDot;

    public NormalFragment() {
        // Required empty public constructor
    }

    public static NormalFragment newInstance() {
        NormalFragment fragment = new NormalFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null){
            mListener.onFragmentInteractionChangeTitle("Mode Normal");
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normal, container, false);
        input = view.findViewById(R.id.input);
        signBox = view.findViewById(R.id.sign);
        hasDot = false;
        Button b0 = view.findViewById(R.id.btn_0);
        Button b1 = view.findViewById(R.id.btn_1);
        Button b2 = view.findViewById(R.id.btn_2);
        Button b3 = view.findViewById(R.id.btn_3);
        Button b4 = view.findViewById(R.id.btn_4);
        Button b5 = view.findViewById(R.id.btn_5);
        Button b6 = view.findViewById(R.id.btn_6);
        Button b7 = view.findViewById(R.id.btn_7);
        Button b8 = view.findViewById(R.id.btn_8);
        Button b9 = view.findViewById(R.id.btn_9);
        Button bplus = view.findViewById(R.id.btn_add);
        Button bmoins = view.findViewById(R.id.btn_subtract);
        Button bmul = view.findViewById(R.id.btn_multiply);
        Button bdiv = view.findViewById(R.id.btn_divide);
        Button bdot = view.findViewById(R.id.btn_dot);
        Button bclear = view.findViewById(R.id.btn_clear);
        Button bdel = view.findViewById(R.id.btn_delete);
        Button bequal = view.findViewById(R.id.btn_equal);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               input.setText(input.getText() + "0");
            }});
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "9");
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "+";
                value1 = input.getText().toString();
                input.setText(null);
                hasDot = false;
                signBox.setText("+");
            }
        });
        bmoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "-";
                value1 = input.getText().toString();
                input.setText(null);
                hasDot = false;
                signBox.setText("-");
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "*";
                value1 = input.getText().toString();
                input.setText(null);
                hasDot = false;
                signBox.setText("×");
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "/";
                value1 = input.getText().toString();
                input.setText(null);
                hasDot = false;
                signBox.setText("÷");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasDot) {
                    if (input.getText().equals("")) {
                        input.setText("0.");
                    } else {
                        input.setText(input.getText() + ".");
                    }
                    hasDot = true;
                }
            }
        });
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(null);
                signBox.setText(null);
                value1 = null;
                value1 = null;
                hasDot = false;
            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (( sign == null) || (input.getText().equals(""))) {
                    signBox.setText("Error");
                }
                else if (sign != null) {
                    String value2 = input.getText().toString();

                    Double num1 = Double.parseDouble(value1);
                    Double num2 = Double.parseDouble(value2);
                    input.setText(null);

                    switch (sign) {
                        default:
                            break;
                        case "+":
                            double result = num1 + num2;
                            input.setText(result + "");
                            sign = null;
                            signBox.setText(null);
                            break;
                        case "-":
                            result = num1 - num2;
                            input.setText(result + "");
                            sign = null;
                            signBox.setText(null);
                            break;
                        case "*":
                            result = num1 * num2;
                            input.setText(result + "");
                            sign = null;
                            signBox.setText(null);
                            break;
                        case "/":
                            result = num1 / num2;
                            input.setText(result + "");
                            sign = null;
                            signBox.setText(null);
                            break;
                    }
                } else signBox.setText("Error");
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().equals("")) {
                    input.setText(null);

                } else {
                    int len = input.getText().length();
                    String s = input.getText().toString();
                    if (s.charAt(len - 1) == '.') {
                        hasDot = false;
                        input.setText(input.getText().subSequence(0, input.getText().length() - 1));
                    } else {
                        input.setText(input.getText().subSequence(0, input.getText().length() - 1));
                    }
                }
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteractionChangeTitle(String title);
    }
}
