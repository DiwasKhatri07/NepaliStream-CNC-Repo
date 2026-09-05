package com.Goojara;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Goojara.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Goojara/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Goojara.Goojara$search$2$deferred$1$1", f = "Goojara.kt", i = {0, 1, 1, 1}, l = {365, 107}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "href", "title"}, nl = {366, 109}, s = {"L$0", "L$0", "L$2", "L$3"}, v = 2)
@SourceDebugExtension({"SMAP\nGoojara.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara$search$2$deferred$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,364:1\n81#2,6:365\n*S KotlinDebug\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara$search$2$deferred$1$1\n*L\n102#1:365,6\n*E\n"})
final class Goojara$search$2$deferred$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MovieSearchResponse>, Object> {
    final /* synthetic */ Element $el;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Semaphore $sem;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ Goojara this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Goojara$search$2$deferred$1$1(Semaphore semaphore, Element element, Goojara goojara, Map<String, String> map, Continuation<? super Goojara$search$2$deferred$1$1> continuation) {
        super(2, continuation);
        this.$sem = semaphore;
        this.$el = element;
        this.this$0 = goojara;
        this.$headers = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Goojara$search$2$deferred$1$1(this.$sem, this.$el, this.this$0, this.$headers, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MovieSearchResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:27:0x00fe A[Catch: all -> 0x0133, Exception -> 0x0139, TryCatch #5 {Exception -> 0x0139, all -> 0x0133, blocks: (B:25:0x00f0, B:27:0x00fe, B:29:0x0107, B:31:0x010f, B:34:0x0117, B:21:0x00e5), top: B:51:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0105  */
    /* JADX WARN: Code duplicated, block: B:31:0x010f A[Catch: all -> 0x0133, Exception -> 0x0139, TryCatch #5 {Exception -> 0x0139, all -> 0x0133, blocks: (B:25:0x00f0, B:27:0x00fe, B:29:0x0107, B:31:0x010f, B:34:0x0117, B:21:0x00e5), top: B:51:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0115  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        Element element;
        Semaphore $this$withPermit$iv;
        Goojara goojara;
        Map<String, String> map;
        int $i$f$withPermit;
        int i;
        Semaphore $this$withPermit$iv2;
        int $i$f$withPermit2;
        int i2;
        String title;
        Goojara goojara2;
        Semaphore $this$withPermit$iv3;
        String str;
        String href;
        Object obj;
        String title2;
        final Goojara goojara3;
        Element elementSelectFirst;
        final String poster;
        Element elementSelectFirst2;
        String finalHref;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv4 = this.$sem;
                element = this.$el;
                Goojara goojara4 = this.this$0;
                Map<String, String> map2 = this.$headers;
                this.L$0 = $this$withPermit$iv4;
                this.L$1 = element;
                this.L$2 = goojara4;
                this.L$3 = map2;
                this.label = 1;
                if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv = $this$withPermit$iv4;
                goojara = goojara4;
                map = map2;
                $i$f$withPermit = 0;
                i = 0;
                try {
                    String href2 = StringsKt.trim(element.attr("href")).toString();
                    title = StringsKt.trim(element.text()).toString();
                    Requests app = MainActivityKt.getApp();
                    String strFixUrl = MainAPIKt.fixUrl(goojara, href2);
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = goojara;
                    this.L$2 = href2;
                    this.L$3 = title;
                    this.label = 2;
                    goojara2 = goojara;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    str = "href";
                    href = href2;
                    try {
                        obj = Requests.get$default(app, strFixUrl, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        title2 = title;
                        goojara3 = goojara2;
                        Document doc = ((NiceResponse) obj).getDocument();
                        elementSelectFirst = doc.selectFirst("div.imrl img");
                        if (elementSelectFirst != null) {
                            poster = elementSelectFirst.attr("src");
                        } else {
                            poster = null;
                        }
                        elementSelectFirst2 = doc.selectFirst("div.snfo h1 a");
                        if (elementSelectFirst2 != null || (finalHref = elementSelectFirst2.attr(str)) == null) {
                            finalHref = href;
                        }
                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(goojara3, title2, MainAPIKt.fixUrl(goojara3, finalHref), TvType.Movie, false, new Function1() { // from class: com.Goojara.Goojara$search$2$deferred$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return Goojara$search$2$deferred$1$1.invokeSuspend$lambda$0$0(poster, goojara3, (MovieSearchResponse) obj2);
                            }
                        }, 8, (Object) null);
                        $this$withPermit$iv3.release();
                        return movieSearchResponseNewMovieSearchResponse$default;
                    } catch (Exception e) {
                        $i$f$withPermit2 = $i$f$withPermit;
                        i2 = i;
                        $this$withPermit$iv2 = $this$withPermit$iv3;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                    } catch (Throwable th) {
                        th = th;
                        $this$withPermit$iv2 = $this$withPermit$iv3;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                } catch (Exception e2) {
                    $i$f$withPermit2 = $i$f$withPermit;
                    i2 = 0;
                    $this$withPermit$iv2 = $this$withPermit$iv;
                    $this$withPermit$iv3 = $this$withPermit$iv2;
                } catch (Throwable th2) {
                    th = th2;
                    $this$withPermit$iv2 = $this$withPermit$iv;
                    $this$withPermit$iv2.release();
                    throw th;
                }
                break;
            case 1:
                map = (Map) this.L$3;
                Goojara goojara5 = (Goojara) this.L$2;
                element = (Element) this.L$1;
                Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                $i$f$withPermit = 0;
                goojara = goojara5;
                $this$withPermit$iv = $this$withPermit$iv5;
                i = 0;
                String href3 = StringsKt.trim(element.attr("href")).toString();
                title = StringsKt.trim(element.text()).toString();
                Requests app2 = MainActivityKt.getApp();
                String strFixUrl2 = MainAPIKt.fixUrl(goojara, href3);
                this.L$0 = $this$withPermit$iv;
                this.L$1 = goojara;
                this.L$2 = href3;
                this.L$3 = title;
                this.label = 2;
                goojara2 = goojara;
                $this$withPermit$iv3 = $this$withPermit$iv;
                str = "href";
                href = href3;
                obj = Requests.get$default(app2, strFixUrl2, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title2 = title;
                goojara3 = goojara2;
                Document doc2 = ((NiceResponse) obj).getDocument();
                elementSelectFirst = doc2.selectFirst("div.imrl img");
                if (elementSelectFirst != null) {
                    poster = elementSelectFirst.attr("src");
                } else {
                    poster = null;
                }
                elementSelectFirst2 = doc2.selectFirst("div.snfo h1 a");
                if (elementSelectFirst2 != null) {
                    finalHref = href;
                } else {
                    finalHref = href;
                }
                movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(goojara3, title2, MainAPIKt.fixUrl(goojara3, finalHref), TvType.Movie, false, new Function1() { // from class: com.Goojara.Goojara$search$2$deferred$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        return Goojara$search$2$deferred$1$1.invokeSuspend$lambda$0$0(poster, goojara3, (MovieSearchResponse) obj2);
                    }
                }, 8, (Object) null);
                $this$withPermit$iv3.release();
                return movieSearchResponseNewMovieSearchResponse$default;
            case 2:
                $i$f$withPermit2 = 0;
                i2 = 0;
                String title3 = (String) this.L$3;
                String href4 = (String) this.L$2;
                goojara3 = (Goojara) this.L$1;
                $this$withPermit$iv2 = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    str = "href";
                    i = 0;
                    href = href4;
                    $this$withPermit$iv3 = $this$withPermit$iv2;
                    obj = $result;
                    title2 = title3;
                    Document doc3 = ((NiceResponse) obj).getDocument();
                    elementSelectFirst = doc3.selectFirst("div.imrl img");
                    if (elementSelectFirst != null) {
                        poster = elementSelectFirst.attr("src");
                    } else {
                        poster = null;
                    }
                    elementSelectFirst2 = doc3.selectFirst("div.snfo h1 a");
                    if (elementSelectFirst2 != null) {
                        finalHref = href;
                    } else {
                        finalHref = href;
                    }
                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(goojara3, title2, MainAPIKt.fixUrl(goojara3, finalHref), TvType.Movie, false, new Function1() { // from class: com.Goojara.Goojara$search$2$deferred$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            return Goojara$search$2$deferred$1$1.invokeSuspend$lambda$0$0(poster, goojara3, (MovieSearchResponse) obj2);
                        }
                    }, 8, (Object) null);
                    break;
                } catch (Exception e3) {
                    $this$withPermit$iv3 = $this$withPermit$iv2;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withPermit$iv2.release();
                    throw th;
                }
                $this$withPermit$iv3.release();
                return movieSearchResponseNewMovieSearchResponse$default;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(String $poster, Goojara this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster == null ? this$0.DEFAULT_POSTER : $poster);
        return Unit.INSTANCE;
    }
}
