
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

//  ����javascript ������ӱ�ǩ<li>������txt�ı�������������div�飿
 
