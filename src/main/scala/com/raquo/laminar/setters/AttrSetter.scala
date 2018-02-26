package com.raquo.laminar.setters

import com.raquo.domtypes.generic.Modifier
import com.raquo.domtypes.generic.keys.Attr
import com.raquo.laminar.DomApi
import com.raquo.laminar.experimental.airstream.core.Observable
import com.raquo.laminar.nodes.ReactiveElement
import org.scalajs.dom

class AttrSetter[V](
  val attr: Attr[V],
  $value: Observable[V]
) extends Modifier[ReactiveElement[dom.Element]] {

  override def apply(element: ReactiveElement[dom.Element]): Unit = {
    element.subscribe(
      $value,
      (value: V) => DomApi.elementApi.setAttribute(element, attr, value)
    )
  }
}