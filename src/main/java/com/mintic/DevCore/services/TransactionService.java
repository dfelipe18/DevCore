package com.mintic.DevCore.services;

import com.mintic.DevCore.interfaces.ITransaction;
import com.mintic.DevCore.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private ITransaction repository;

    /*
     * Método para listar todas las transacciones.
     * Creamos una lista de transacciones y luego realizamos la búsqueda
     * de todos los registros y los añadimos a la lista, luego retornamos la lista.
     */
    public List<Transaction> listAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(repository.findAll());
        return transactions;
    }

    /*
    * Método para listar una transacción por el ID, primero buscamos
    * la transacción por su ID, luego valdiamos si está presente en la consulta
    * y por último retornamos el objeto encontrado.
    */
    public Optional<Transaction> listTransactionById(long id) {
        Optional<Transaction> transaction = repository.findById(id);
        return transaction;
    }

    /*
     * Método para guardar una transacción.
     * Validamos que el objeto sea diferente de nulo, y luego pasamos
     * el objeto al método de guardar y retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        if (!transaction.equals(null)) {
            repository.save(transaction);
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*
     * Método para actualizar una transacción.
     * Validamos que exista la transacción, luego recorremos todos los campos
     * que está seteando el usuario y a cada uno de esos campos le seteamos el valor
     * correspondiente, sin afectar los campos que no se necesiten actualizar.
     */

    public ResponseEntity<Transaction> updateTransaction(Long id, Map<Object, Object> fields) {
        Optional<Transaction> transaction = repository.findById(id);
        if (transaction.isPresent()) {
            Transaction updateTransaction = transaction.get();
            fields.forEach((key, value) -> {
                // use reflection to get field k on Transaction and set it to value v
                Field field = ReflectionUtils.findField(Transaction.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, updateTransaction, value);
            });
            repository.save(updateTransaction);
            return ResponseEntity.ok(updateTransaction);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    /*
     * Método para eliminar una transacción.
     * Validamos que el objeto esté presente y luego le pasamos el ID,
     * para su eliminación, por último retornamos el HTTP RESPONSE.
     */
    public ResponseEntity<Void> deleteTransaction(Long id) {
        Optional<Transaction> transaction = repository.findById(id);
        if (transaction.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.ok(null);
    }
}
