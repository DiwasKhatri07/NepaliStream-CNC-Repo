package com.hindmoviez;

import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: hindmoviez.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u000b\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/hindmoviez/HindmoviezLinkData;", "epAnchor", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.hindmoviez.Hindmoviez$load$5$results$1", f = "hindmoviez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$5$results$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,454:1\n1#2:455\n*E\n"})
final class Hindmoviez$load$5$results$1 extends SuspendLambda implements Function2<Element, Continuation<? super Pair<? extends Integer, ? extends HindmoviezLinkData>>, Object> {
    final /* synthetic */ String $ajaxUrl;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Hindmoviez$load$5$results$1(String str, Continuation<? super Hindmoviez$load$5$results$1> continuation) {
        super(2, continuation);
        this.$ajaxUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hindmoviez$load$5$results$1 = new Hindmoviez$load$5$results$1(this.$ajaxUrl, continuation);
        hindmoviez$load$5$results$1.L$0 = obj;
        return hindmoviez$load$5$results$1;
    }

    public final Object invoke(Element element, Continuation<? super Pair<Integer, HindmoviezLinkData>> continuation) {
        return create(element, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List groupValues;
        String str;
        Integer intOrNull;
        Element epAnchor = (Element) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MatchResult matchResultFind$default = Regex.find$default(new Regex("Episode\\s*(\\d+)", RegexOption.IGNORE_CASE), epAnchor.text(), 0, 2, (Object) null);
                if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                    return null;
                }
                int episodeNumber = intOrNull.intValue();
                String href = epAnchor.absUrl("href");
                if (StringsKt.isBlank(href)) {
                    href = null;
                }
                if (href == null) {
                    return null;
                }
                String domain = StringsKt.substringBefore$default(href, "/?id=", (String) null, 2, (Object) null);
                String rawId = CodecsKt.decodeURLQueryComponent$default(StringsKt.replace$default(StringsKt.substringAfter$default(href, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), 0, 0, false, (Charset) null, 15, (Object) null);
                return TuplesKt.to(Boxing.boxInt(episodeNumber), new HindmoviezLinkData(rawId, domain, this.$ajaxUrl));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
