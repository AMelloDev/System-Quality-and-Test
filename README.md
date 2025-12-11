**📘 Projeto IMC – API REST com Spring Boot**
Este projeto disponibiliza cálculos relacionados à saúde por meio de endpoints REST desenvolvidos em Spring Boot.

Start the pring boot server:
mvn spring-boot:run

Use the Rest adresses to send the values and receive the responses from each method on the browser:

Address to Body Mass Index:
http://localhost:8080/api/imc/calcular?peso=70&altura=1.75

- Entrada esperada: peso (double), altura(double)
- Cálculo: imc = peso / (altura * altura);
-  Saída: "Seu IMC é: " + String.format("%.2f", imc)

Endereço para Taxa Metabólica basal:
http://localhost:8080/api/imc/tmb?peso=70&alturaCm=175&idade=25&sexo=masculino

- Entrada esperada: peso (double), alturaCm(double), idade(int), sexo(string)
- Cálculo: 
  - Se for sexo masculino:
          tmb = (10 * peso) + (6.25 * alturaCm) - (5 * idade) + 5;
  - Se for do sexo feminino:
          tmb = (10 * peso) + (6.25 * alturaCm) - (5 * idade) - 161;

- Saída: "TMB:" + String.format("%.2f", tmb) + " kcal/dia"

**Endereço para bater Meta de caloria:**
http://localhost:8080/api/imc/meta?gcd=2500&objetivo=emagrecer

- Entrada esperada: gcd (double), objetivo(string)
- Cálculo: 
  - Se o objetivo for emagrecer:
         meta = gcd - 500;
  - Se o objetivo for ganhar:
         meta = gdc + 400;
  - Se o objetivo for manter:
         meta = gdc;
- Saída:
  - "Meta calórica (" + objetivo + "): " + valor
  - "Objetivo inválido. Use: emagrecer, ganhar ou manter."

**Endereço para Gasto Calórico Diário:**
http://localhost:8080/api/imc/gcd?peso=70&alturaCm=175&idade=25&sexo=feminino

- Entrada esperada: peso (double), alturaCm(double), idade(int), sexo(string)
- Cálculo: 
  - Se for sexo masculino:
        calorias = 66 + (13.7 * peso) + (5 * alturaCm) - (6.8 * idade);
  - Se for do sexo feminino:
        calorias = 655 + (9.6 * peso) + (1.8 * alturaCm) - (4.7 * idade);

- Saída: "Calorias gastas por dia: " + String.format("%.2f", calorias)

**Teste de carga**
O teste de carga usa estes endereços na quantidade de usuários definida, resultando se a operação foi bem sucedida e qual o resultado que cada um dos usuários retornou, segue abaixo prints dos testes de carga realizados:

- IMC:
<img width="1457" height="184" alt="image" src="https://github.com/user-attachments/assets/653c4ba8-cfbf-4e8d-b187-476ecd09ce90" />
<img width="491" height="699" alt="image" src="https://github.com/user-attachments/assets/5d79d8a2-ad37-480c-b1cf-2423e51df3f8" />

- Taxa Metabólica basal:
<img width="1428" height="162" alt="image" src="https://github.com/user-attachments/assets/a4bdbfe7-18e6-436e-9383-a2a673b37eee" />
<img width="502" height="676" alt="image" src="https://github.com/user-attachments/assets/29c3e553-6b27-44ad-9380-5bd175e6c4a4" />

- Meta de caloria:
<img width="1429" height="140" alt="image" src="https://github.com/user-attachments/assets/3451d7ce-4cd1-434b-9845-361580dc7413" />
<img width="619" height="675" alt="image" src="https://github.com/user-attachments/assets/7b569a54-0874-445d-9ff9-a88349478092" />

- Gasto Calórico Diário:
<img width="1434" height="143" alt="image" src="https://github.com/user-attachments/assets/84e63751-1e28-4a6f-ad3f-d169a52dc675" />
<img width="607" height="677" alt="image" src="https://github.com/user-attachments/assets/ae805dd4-0b42-467c-af5b-0484070b8b9d" />

**Print do teste unitátio com Junit:**
<img width="1486" height="611" alt="image" src="https://github.com/user-attachments/assets/c4842257-20e5-48a1-9141-b3192752e918" />



- Uso de IA:
Utilizamos a Inteligência artificial do GPT para nos auxilar no tratamento de erros(Porta 8080 já estar sendo utilizada, estarmos pedindo double mas estávamso recebendo string), também para aprendermos a utilizar a plataforma jMeter.
