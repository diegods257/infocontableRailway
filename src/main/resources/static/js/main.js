
$(document).ready(
    function () {
        $(".hoverfontsize").hover(function () {
            console.log("hover event launched")
        })
    }
)



function setFooterContainer() {
    $("#footer_container").html(`  <div class="container">    <!--los contenedores en auto siempre centran los elementos(no el contenido)-->
    <!-- <div class="border-bottom"></div>  -->
     <footer class="py-1 my-4 ">
<!--         <ul class="nav justify-content-center pb-3 mb-3">-->
<!--             <li class="nav-item"><a id="textHeaderAndFooter" href="/servicios.html" class="nav-link px-2 text-muted">Servicios </a></li>  -->
<!--             <li class="nav-item"><a id="textHeaderAndFooter" href="/nosotros.html" class="nav-link px-2 text-muted">Nosotros </a></li>-->
<!--         </ul>-->
         <!--<div class="border-bottom mx-auto mb-3 w-50"></div> -->  <!--w-50  width(25,50,75,100)  tamano hijo del 50%. m propiedad margin, p propiedad padding, mx margin en el eje x tanto izquierda como derecha o puede ser auto para que quede centrado , s(start o izquierda), e(end o derecha) , y, arriba y abajo, t(top), b(bottom)  pb-3(del 0 a 5) -->
         <p id="textHeaderAndFooter" class=" text-center text-muted">© 2022 Company, Inc</p>
     </footer>
 </div>
    `
    );
}