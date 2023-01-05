// File path: src/view/com/passion/view/AdviceView.java                     (2)

package com.passion.view;

import com.passion.model.AdviceModel;             // From model module.

public class AdviceView {

  private AdviceModel model;

  public AdviceView(AdviceModel model) { this.model = model; }

  public void updateAdviceDisplay(){
    System.out.println(model.getCurrentAdvice());
  }
}