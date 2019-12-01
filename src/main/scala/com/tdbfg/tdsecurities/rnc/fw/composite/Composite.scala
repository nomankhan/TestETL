package com.tdbfg.tdsecurities.rnc.fw.composite

trait Composite[I] extends Component[I] {
  var children:List[Component[I]] =  List()
  override def +=(_child: Component[I]): Unit = {
    children ::= _child
  }
}