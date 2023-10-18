let doc=document.querySelector("#menu li");
doc.addEventListener('click',function(){
    this.addClass('active').sibling().removeClass('active');
});