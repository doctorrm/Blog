
function add(n,txt)
 {
  var s=document.getElementById('s');
  var t=s.childNodes.length;
  var li= document.createElement("li");
  li.innerHTML=txt;
  for (var i=0;i<t;i++)
  {
   if (n==-1)
   {
    s.appendChild(li);
   }  }
 }

//  上面javascript 如何增加标签<li>而不是txt文本？或者如何添加div块？
 
