# 分布式Java应用基础

[TOC]

## 系统间通信

### 基于消息方式实现系统间通信

**消息**：字节流/字节数组/Java对象。消息方式的系统间通信，通常由**网络协议**来实现。

#### TCP/IP+BIO

在java中可基于**Socket**(建立连接及网络IO的操作)、**ServerSocket**(服务器端端口的监听及Socket对象的获取)来实现TCP/IP+BIO的系统间通信。

#### TCP/IP+NIO

java中基于java.nio.channels**中的Channel**和**Selector**实现TCP/IP+NIO方式的系统间通信。

- **Channel**：SocketChannel建立连接、监听事件及操作读写；ServerSocketChannel监听端口及监听连接事件；
- **Selector**：获取是否有要处理的事件

#### UDP/IP+BIO

- java中采用**DatagramSocket**(监听端口及读写数据)和**DatagramPacket**(作为数据流对象进行传输)实现UDP/IP+BIO方式的系统间通信；
- java中基于**MulticastSocket**和**DatagramPacket**实现多播网络通信

#### UDP/IP+NIO

java中采用**DatagramChannel**(监听端口及进行读写)和**ByteBuffer**(数据流传输)来实现UDP/IP+NIO方式的系统间通信。

> `BIO`:当发起IO读或写操作时均为**阻塞**的；
>
> `NIO`:采用`Reactor`模式，基于事件驱动，发起IO读或写操作时是**非阻塞**的；
>
> `AIO`:采用`Proactor`模式，基于事件驱动，异步，进行读写操作时只须直接调用API的read或write方法。

#### Mina

- 开源框架，基于Java NIO构建，同时支持TCP/IP和UDP/IP两种协议。

### 基于远程调用实现系统间通信

#### RMI

- java用于实现透明远程调用的重要机制，基于TCP/IP+BIO。
- **RMI服务器**：通过启动`RMI注册对象`监听对外提供的接口，它的实现实例是以`字符串`的方式绑定到RMI注册对象上；接受到客户端请求对象后，`反序列化`解析对象字符串、方法和参数，通过对象字符串从RMI注册对象上`获取对象实例`，通过`反射`完成对服务器端对象实例的调用，返回的结果序列化成流以TCP/IP+BIO方式返回给客户端。
- **RMI客户端**：通过`代理`方式代理了对服务器端接口的访问，将对象字符串、方法和参数`封装`成一个对象，`序列化`成流后通过`TCP/IP+BIO`传输到RMI服务器端。

#### WebService

- 是**跨语言**的系统间交互标准。对外提供功能方以`HTTP`方式提供服务，服务采用`WSDL`描述，描述服务所使用的协议、参数、返回的参数格式等。调用端和服务端通过`SOAP`方式进行交互。
- **调用过程**：将服务端的服务根据描述生成相应的WSDL文件，并将应用和WSDL文件部署到HTTP服务器中。客户端通过`wsimport`根据WSDL文件生成客户端stub辅助代码——将产生的对象请求信息封装成标准的SAOP格式数据，并发送到服务器端，服务器端接受数据后进行转化，反射调用相应的Java类。

#### Spring RMI

- **工作原理**：![Spring RMI工作原理](/Users/jo/Documents/学习文档/spring/Spring RMI/Spring RMI工作原理.png)

#### CXF

- 与WebService比较：服务端只提供了`JaxWsServerFactoryBean`类可以在WS被调用时增加一些拦截器的处理；客户端增加封装，`JaxWsProxyFactoryBean`以接口方式调用远程的WebService。





