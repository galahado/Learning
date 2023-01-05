// Filepath: src/controller/module-info.java
module controller {
  requires model;
  requires view;
  opens com.passion.controller;
  // exports com.passion.controller;
}