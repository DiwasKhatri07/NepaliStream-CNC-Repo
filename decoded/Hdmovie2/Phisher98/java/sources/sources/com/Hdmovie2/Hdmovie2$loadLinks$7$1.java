package com.Hdmovie2;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Hdmovie2.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hdmovie2/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Hdmovie2.Hdmovie2$loadLinks$7$1", f = "Hdmovie2.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {403, 404}, m = "invokeSuspend", n = {"element", "label", "href", "element", "label", "href", "redirectedurl"}, nl = {404, 406}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 2)
final class Hdmovie2$loadLinks$7$1 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ Hdmovie2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Hdmovie2$loadLinks$7$1(Hdmovie2 hdmovie2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Hdmovie2$loadLinks$7$1> continuation) {
        super(2, continuation);
        this.this$0 = hdmovie2;
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hdmovie2$loadLinks$7$1 = new Hdmovie2$loadLinks$7$1(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        hdmovie2$loadLinks$7$1.L$0 = obj;
        return hdmovie2$loadLinks$7$1;
    }

    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:26:0x00e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00e1  */
    public final Object invokeSuspend(Object $result) {
        String strText;
        String label;
        Object obj;
        String label2;
        String href;
        String redirectedurl;
        String redirectedurl2;
        Element element = (Element) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Element elementSelectFirst = element.selectFirst("button");
                if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (label = StringsKt.trim(strText).toString()) == null) {
                    return Unit.INSTANCE;
                }
                String href2 = element.attr("href");
                if (StringsKt.contains(label, "GDFlix", true)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(label);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(href2);
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), href2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4062, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    label2 = label;
                    href = href2;
                    redirectedurl = ((NiceResponse) obj).getHeaders().get("location");
                    if (redirectedurl == null) {
                        redirectedurl = "";
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(label2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(href);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(redirectedurl);
                    this.label = 2;
                    if (ExtractorApiKt.loadExtractor(redirectedurl, this.this$0.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    redirectedurl2 = label2;
                }
                return Unit.INSTANCE;
            case 1:
                href = (String) this.L$2;
                String label3 = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                label2 = label3;
                obj = $result;
                redirectedurl = ((NiceResponse) obj).getHeaders().get("location");
                if (redirectedurl == null) {
                    redirectedurl = "";
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                this.L$1 = SpillingKt.nullOutSpilledVariable(label2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(href);
                this.L$3 = SpillingKt.nullOutSpilledVariable(redirectedurl);
                this.label = 2;
                if (ExtractorApiKt.loadExtractor(redirectedurl, this.this$0.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                redirectedurl2 = label2;
                return Unit.INSTANCE;
            case 2:
                href = (String) this.L$2;
                redirectedurl2 = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
