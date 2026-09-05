package com.hindmoviez;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: hindmoviez.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000b\u0010\u0003\u001a\u00070\u0004¢\u0006\u0002\b\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/hindmoviez/HindmoviezLinkData;", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.hindmoviez.Hindmoviez$load$hrefs$1", f = "hindmoviez.kt", i = {0, 0}, l = {203}, m = "invokeSuspend", n = {"element", "listUrl"}, nl = {204}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$hrefs$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,454:1\n1795#2,10:455\n2068#2:465\n2069#2:467\n1805#2:468\n1795#2,10:469\n2068#2:479\n2069#2:481\n1805#2:482\n1#3:466\n1#3:480\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$hrefs$1\n*L\n204#1:455,10\n204#1:465\n204#1:467\n204#1:468\n209#1:469,10\n209#1:479\n209#1:481\n209#1:482\n204#1:466\n209#1:480\n*E\n"})
final class Hindmoviez$load$hrefs$1 extends SuspendLambda implements Function2<Element, Continuation<? super List<? extends HindmoviezLinkData>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    Hindmoviez$load$hrefs$1(Continuation<? super Hindmoviez$load$hrefs$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hindmoviez$load$hrefs$1 = new Hindmoviez$load$hrefs$1(continuation);
        hindmoviez$load$hrefs$1.L$0 = obj;
        return hindmoviez$load$hrefs$1;
    }

    public final Object invoke(Element element, Continuation<? super List<HindmoviezLinkData>> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        String listUrl;
        HindmoviezLinkData hindmoviezLinkData;
        List groupValues;
        Element element = (Element) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str = "href";
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String listUrl2 = element.absUrl("href");
                if (StringsKt.isBlank(listUrl2)) {
                    return CollectionsKt.emptyList();
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                this.L$1 = SpillingKt.nullOutSpilledVariable(listUrl2);
                this.label = 1;
                obj = Requests.get$default(MainActivityKt.getApp(), listUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                listUrl = listUrl2;
                break;
                break;
            case 1:
                listUrl = (String) this.L$1;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document listDoc = ((NiceResponse) obj).getDocument();
        Iterable $this$mapNotNull$iv = listDoc.select("script");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element script = (Element) element$iv$iv$iv;
            Element element2 = element;
            String listUrl3 = listUrl;
            MatchResult matchResultFind$default = Regex.find$default(new Regex("AJAX_URL\\s*=\\s*['\"]([^'\"]+)['\"]"), script.html(), 0, 2, (Object) null);
            String str2 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) groupValues.get(1);
            if (str2 != null) {
                destination$iv$iv.add(str2);
            }
            element = element2;
            listUrl = listUrl3;
        }
        String ajaxUrl = (String) CollectionsKt.firstOrNull((List) destination$iv$iv);
        if (ajaxUrl == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$mapNotNull$iv2 = listDoc.select("div.entry-content a:contains(Get Links)");
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv2 = new ArrayList();
        Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
        for (Object element$iv$iv$iv2 : $this$mapNotNullTo$iv$iv) {
            Element anchor = (Element) element$iv$iv$iv2;
            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
            String href = anchor.absUrl(str);
            if (StringsKt.isBlank(href)) {
                hindmoviezLinkData = null;
            } else {
                String domain = StringsKt.substringBefore$default(href, "/?id=", (String) null, 2, (Object) null);
                String rawId = CodecsKt.decodeURLQueryComponent$default(StringsKt.replace$default(StringsKt.substringAfter$default(href, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), 0, 0, false, (Charset) null, 15, (Object) null);
                hindmoviezLinkData = new HindmoviezLinkData(rawId, domain, ajaxUrl);
            }
            if (hindmoviezLinkData != null) {
                destination$iv$iv2.add(hindmoviezLinkData);
            }
            $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
            $i$f$mapNotNull = $i$f$mapNotNull;
            listDoc = listDoc;
            str = str;
            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
        }
        return (List) destination$iv$iv2;
    }
}
