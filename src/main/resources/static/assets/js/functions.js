function deleteItem(id, route, routeResponse) {
    Swal.fire({
      title: '¿Está seguro de eliminar el registro?',
      showCancelButton: true,
      confirmButtonText: 'Eliminar',
      confirmButtonColor: '#DD1818'
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        $.ajax({
            url: route + id,
            success: function(res) {
                Swal.fire('El registro fue eliminado exitosamente', '', 'success').then((confirmMsg) =>{
                    if(confirmMsg) {
                        location.href = routeResponse;
                    }
                })
            }
        })

      }
    })
}