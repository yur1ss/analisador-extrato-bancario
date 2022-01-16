# analisador-extrato-bancario
Projeto de estudos referente ao livro Desenvolvimento Real de Software.
<br>
<br>

## PRINCÍPIO DE RESPONSABILIDADE ÚNICA
O *Single Responsibility Principle* (SRP) torna nosso desenvolvimento de software mais fácil de gerenciar e manter, uma vez que se pensarmos nele como duas formas complementares:
- Uma classe só deve se responsabilizar por uma única funcionalidade.
- Só deve existir uma única razão para que uma classe mude.

Obs.: Você pode verificar essa diretriz na classe **BankStatementCSVParser**.
<br>

## PRINCÍPIO OPEN/CLOSED
O *Open/Closed Principle* promove a ideia de que deve ser capaz alterar o comportamento de uma classe ou método sem a
necessidade de modificar o código. Abaixo enumerei três motivos para que esse princípio deva ser seguido:
- Reduz a fragilidade do código, uma vez que não altera o código existente.
- Evita a duplicação pq podemos reutilizar o código existente.
- Promove a dissociação, o que leva a uma manutenção melhor do código.

Obs.: Você pode verificar essa diretriz na interface funcional **IBankTransactionFilter** que é utilizada na classe 
**BankStatementProcessor**.
<br>

## TESTE UNITÁRIOS
Para o testes unitários, optei pelo padrão *Given-When-Then* que contem três estágio para configurar um teste unitário.
Explicando melhor, esse padrão consiste em:
1. Você define o contexto para o seu teste.
2. Realiza uma ação.
3. Verifica se a saída é a esperada.

Obs.: Você pode verificar esse padrão na classe **BankStatementCSVParserTest**.
<br>
