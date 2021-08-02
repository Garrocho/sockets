# Sockets
Permite a troca de mensagens entre processos executados no mesmo dispositivo ou em diferentes dispositivos.

## Portas
Um socket deve ser associado a um endereço IP e a uma porta (0-65535) de um dispositivo.

## Processos Cliente e Servidor
Um programa servidor cria um socket e o mantém escutando em uma porta conhecida. O programa cliente cria um socket, conecta-o ao servidor (ip/porta) e envia/recebe dados usando uma porta aleatória.

### Comunicação entre processos no mesmo dispositivo
<img src="https://github.com/Garrocho/sockets/blob/main/mesmo_dispositivo.png" width="250">

### Comunicação entre processos em dispositivos diferentes
<img src="https://github.com/Garrocho/sockets/blob/main/diferentes_dispositivos.png" width="450">
