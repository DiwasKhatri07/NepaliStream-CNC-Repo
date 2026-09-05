package com.dudefilms;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: dudefilms.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DudeFilms/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005H\n"}, d2 = {"<anonymous>", "", "", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.dudefilms.Dudefilms$load$hrefs$1", f = "dudefilms.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"element"}, nl = {115}, s = {"L$0"}, v = 2)
@SourceDebugExtension({"SMAP\ndudefilms.kt\nKotlin\n*S Kotlin\n*F\n+ 1 dudefilms.kt\ncom/dudefilms/Dudefilms$load$hrefs$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n1795#2,10:262\n2068#2:272\n2069#2:275\n1805#2:276\n1#3:273\n1#3:274\n*S KotlinDebug\n*F\n+ 1 dudefilms.kt\ncom/dudefilms/Dudefilms$load$hrefs$1\n*L\n117#1:262,10\n117#1:272\n117#1:275\n117#1:276\n117#1:274\n*E\n"})
final class Dudefilms$load$hrefs$1 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends String>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    Dudefilms$load$hrefs$1(Continuation<? super Dudefilms$load$hrefs$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dudefilms$load$hrefs$1 = new Dudefilms$load$hrefs$1(continuation);
        dudefilms$load$hrefs$1.L$0 = obj;
        return dudefilms$load$hrefs$1;
    }

    public final Object invoke(Element element, Continuation<? super List<String>> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Element element = (Element) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), element.absUrl("href"), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$mapNotNull$iv = ((NiceResponse) obj).getDocument().select("a.maxbutton");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            String p0 = it.absUrl("href");
            if (StringsKt.isBlank(p0)) {
                p0 = null;
            }
            if (p0 != null) {
                destination$iv$iv.add(p0);
            }
        }
        return (List) destination$iv$iv;
    }
}
