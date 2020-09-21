<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Self Garage</title>

  <!-- Bootstrap core CSS -->
  <link href="/promotion/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="/promotion/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
  <script src="https://www.gstatic.com/firebasejs/7.19.1/firebase.js"></script>
  <!-- Custom styles for this template -->
  <link href="/promotion/css/agency.min.css" rel="stylesheet">
	  <link href="/promotion/css/agency.css" rel="stylesheet">

  <meta content="width=device-width, initial-scale=1" name="viewport" />

  <link rel="icon" href="/promotion/img/service/self-garage.jpeg">
    <meta name="mobile-web-app-capable" content="yes">
</head>

<body id="page-top">
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Self Garage</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#services">Projemiz</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#portfolio">Hizmetlerimiz</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#about">Hakkımızda</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#team">Takımımız</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">İletişim</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Header -->
  <header class="masthead">
    <div class="container">
      <div class="intro-text">
        <div class="intro-lead-in">Park Noktalarındaki Dijital Dönüşüm</div>
        <div class="intro-heading text-uppercase">SELF GARAGE</div>

      </div>
    </div>
  </header>

  <!-- Services -->
  <section class="page-section " id="services">

    	<img src="/promotion/img/service/self-garage.jpeg" class="img-fluid center" alt="Responsive image">

    	<p id="production_text" class="text-center p-3 mb-2 bg-light text-dark">
          Günümüzde yoğun trafik birçok şehirde başlıca problemlerden biri haline gelmiştir. Bu trafiğin büyük bir bölümünü ise park yeri arayan araçlar oluşturmaktadır. Park yeri aramak belirli bölgelerde çok zor hale gelmiş, otoparklar yetersiz kalmış ve yasadışı değnekçiler, otopark mafyaları ortaya çıkmıştır .
          Bunun sonucunda araç sahipleri park yeri ararken büyük stres yaşamakta, trafik cezaları yemekte, zaman kaybetmekte ve yakıtının bir kısmını israf etmektedir. Araç sahipleri bu problemleri yaşarken kişisel otopark sahipleri ise kendi alanlarının kullanılmaması için belli bir bariyer koymakta ve diğer araçların bu alanlara girişini engellemektedir. Bu sebeple, bu alanlar boş kalırken, belli alanlara düzensiz park edilip, trafiğin kitlenmesinde büyük rol oynayan ve çevrenin egzoz dumanıyla kirletildiği kötü manzaralarla karşılaşmaktayız.
          Self Garage projemiz ile, kişisel park alanlarını gelir modeli haline getirerek, park alanı sahiplerine otoparklarını kullanmadıkları zaman, kullanıma açtırıp, park yeri arayan diğer araç şoförlerine bu alanları kolay bir şekilde ulaştırmayı amaçlıyoruz. Böylece araç sahipleri için park yeri ararken yaşanan stresi bitirme imkanı sağlıyoruz. Trafikteki araç yoğunluğunu da bu çözüm ile gidermiş oluyoruz.
          Mekanik, elektronik ve yazılımdan oluşan 3 temel platformumuz ile bu hizmeti kaliteli ve kullanışlı bir şekilde vermeyi amaçlıyoruz.
          Çalışma mekanizmasında, otopark sahibi alanını istediği bir saatte kendi hesabı üzerinden açarak, diğer sürücülerin haritalarına düşüp park imkanı sağlanmış oluyor. Otoparka gitmek isteyen sürücü üzerine tıklayınca alana yönlendirilip vardığı zaman duba otomatik olarak açılıyor ve çıkış yaptığında kalma süresi otomatik olarak hesaplanıp ücret kredi kartından çekiliyor fakat demo aşamasında ücret alınmamaktadır. Böylece her iki tarafın da kazançlı çıkması ile birlikte, trafik yoğunluğu da azalmış oluyoruz. İnsanlar için de temiz bir çevre ile dijital bir şehir hediye etmiş oluyoruz.</p>
  </section>


  <!-- Portfolio Grid -->
  <section class="bg-light page-section" id="portfolio">

<div class="card RegisterCard1" style="width: 25rem; float: left">
  <img class="card-img-top" src="/promotion/img/service/mobile.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title"> PARK YERİ Mİ ARIYORSUNUZ ?</h5>
    <p class="card-text"> Sistemimize Kayıt olarak kolay, ucuz ve güvenli park yeri bulabilir. Park yeri ararken ki streslerinizden kurtulabilir,
    zaman ve yakıt tasaarufu sağlayabilirsiniz.</p>
    <a href="/driverSignUp" class="btn btn-primary"> KAYIT </a>
    <a href="/driverLogin" class="btn btn-primary">GİRİŞ</a>
  </div>


</div>

<div class="card RegisterCard2" style="width: 25rem; ">
  <img class="card-img-top" src="/promotion/img/service/park.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">PARK YERİNİZİ KİRALAMAK MI İSTİYORSUNUZ ?</h5>
    <p class="card-text"> Park yerinizi kiralamak için kayıt butonuyla bizimle iletişime geçebilir, kullanmadığınız zamanlarda ek gelir elde edebilirsiniz. </p>
    <a href="/ownerSignUp" class="btn btn-primary">KAYIT</a>
    <a href="/ownerLogin" class="btn btn-primary">GİRİŞ</a>
  </div>
</div>

  </section>

  <!-- About -->
  <section class="page-section" id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Hakkımızda</h2>
          <h3 class="section-subheading text-muted">Hikayemiz nasıl mı başladı ?.</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <ul class="timeline">

            <li class="timeline-inverted">
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="/promotion/img/service/teknofest.png" alt="" style="margin-top: 15px">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>Eylül 2020</h4>
                  <h4 class="subheading">Teknofest 2020</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">  Teknofest 2020 Akıllı Ulaşım Yarışmasında 4. sıradan finale kaldık.
                  </p>
                </div>
              </div>
            </li>

            <li>
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="/promotion/img/service/self-garage.jpeg" alt="" style="height: 100%">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>Nisan 2020</h4>
                  <h4 class="subheading">Prototip Aşaması</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted">Projenin prototip geliştirme aşaması başladı.</p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <img class="rounded-circle img-fluid" src="/promotion/img/about/1.jpeg" alt="">
              </div>
              <div class="timeline-panel">
                <div class="timeline-heading">
                  <h4>Aralık 2019</h4>
                  <h4 class="subheading">Projenin Ortaya Çıkışı</h4>
                </div>
                <div class="timeline-body">
                  <p class="text-muted"> T.C Cumhuriyeti Cumhurbaşkanlığı himayelerinde TURKSAT A.Ş Tarafından düzenlenen Dijital Türkiye Fikir Maratonu
                  etkinliğine daha dijital bir Türkiye hayal ederek çıkara ülkemizin büyük sorunu olan trafik ve park problemlerine çözüm bularak Dijital Değnekçiler ekibimizi kurduk.
                  Geliştirdiğimiz Self Garage projemiz ile 169 takım 584 üniversite öğrencisi arasından projemiz birinciliğe layık görüldü ve 15.000 tl hibe almaya hak kazandı.
                  </p>
                </div>
              </div>
            </li>
            <li class="timeline-inverted">
              <div class="timeline-image">
                <h4>
                Hikayemiz
                <br>
                Burada
                  <br>Başlıyor
                  </h4>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>

  <!-- Team -->
  <section class="bg-light page-section" id="team">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Takımımız</h2>
          <h3 class="section-subheading text-muted">Ekibimizin Çekirdek Üyeleri</h3>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/1.jpg" alt="">
            <h4>Murat Yıldız</h4>
            <p class="text-muted">Yazılım Geliştirici</p>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/2.jpg" alt="">
            <h4>Büşra Çaldıran</h4>
            <p class="text-muted">Malzemeci</p>
          </div>
        </div>

        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/3.jpeg" alt="">
            <h4>Abdulkadir Yaldız</h4>
            <p class="text-muted">Ürün Geliştirici ve Tasarımcı</p>
          </div>
        </div>

        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/4.jpeg" alt="">
            <h4> Yunus Emre Mavi</h4>
            <p class="text-muted">Elektronikci</p>
          </div>
        </div>

        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/5.jpeg" alt="">
            <h4>Abdurrahman Kocağa </h4>
            <p class="text-muted">İş Geliştirici</p>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="team-member">
            <img class="mx-auto rounded-circle" src="/promotion/img/team/6.jpeg" alt="">
            <h4>Beyza Öztürk </h4>
            <p class="text-muted">Pazarlamacı</p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8 mx-auto text-center">
          <p class="large text-muted"></p>
        </div>
      </div>
    </div>
  </section>



  <!-- Contact -->
  <section class="page-section" id="contact">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">BİZİMLE İLETİŞİME GEÇİN</h2>

        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <form id="contactForm" name="sentMessage" novalidate="novalidate">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <input class="form-control" id="name" type="text" placeholder="İsminiz *" required="required" data-validation-required-message="Lütfen isminizi giriniz.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="email" type="email" placeholder="Mail Adresiniz *" required="required" data-validation-required-message="Lütfen mail adresinizi giriniz.">
                  <p class="help-block text-danger"></p>
                </div>
                <div class="form-group">
                  <input class="form-control" id="phone" type="tel" placeholder="Telefonunuz *" required="required" data-validation-required-message="Lütfen telefon numaranızı giriniz.">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <textarea class="form-control" id="message" placeholder="Mesajınız *" required="required" data-validation-required-message="Lütfen mesajınızı giriniz."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="clearfix"></div>
              <div class="col-lg-12 text-center">
                <div id="success"></div>
                <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">GÖNDER</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer class="footer">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-4">
          <span class="copyright">SelfGarage &copy; 2020</span>
        </div>
        <div class="col-md-4">
          <img src="/promotion/img/service/self-garage.jpeg" alt="logo" width="100" height="50">
        </div>
        <div class="col-md-4">
          <ul class="list-inline quicklinks">
            <li class="list-inline-item">
              <a href="#">SelfGarage Tüm Hakları Saklıdır</a>
            </li>

          </ul>
        </div>
      </div>
    </div>
  </footer>



  <!-- Bootstrap core JavaScript -->
  <script src="/promotion/vendor/jquery/jquery.min.js"></script>
  <script src="/promotion/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="/promotion/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="/promotion/js/jqBootstrapValidation.js"></script>
  <script src="/promotion/js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="/promotion/js/agency.min.js"></script>


  <script>

    var firebaseConfig = {
      apiKey: "AIzaSyD2-gpjSfAS2QXXO1Ho0X5yWQHvmCdAUUs",
      authDomain: "self-garage.firebaseapp.com",
      databaseURL: "https://self-garage.firebaseio.com",
      projectId: "self-garage",
      storageBucket: "self-garage.appspot.com",
      messagingSenderId: "383027804024",
      appId: "1:383027804024:web:7bd2a6f363799d8d133a8d"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    var flag=1;
    readData();

    function readData(){
      firebase.database().ref('/').on('value',(snap)=>{

      if(flag==1){
        flag=0;
        var data= snap.val().counter;
        data=data+1;
        console.log(data);
        writeData(data);

      }

      });
    }
    function writeData(data) {
      firebase.database().ref("/").update({
        counter:data
      });
    }
  </script>


</body>



</html>