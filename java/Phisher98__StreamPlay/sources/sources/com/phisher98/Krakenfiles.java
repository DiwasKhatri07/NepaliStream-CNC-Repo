package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Krakenfiles;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Krakenfiles extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Krakenfiles";

    @NotNull
    private final String mainUrl = "https://krakenfiles.com";

    /* JADX INFO: renamed from: com.phisher98.Krakenfiles$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Krakenfiles", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2600, 2607}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "doc", "title", "link", "quality"}, nl = {2601, 2606}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00361 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00361(Continuation<? super C00361> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Krakenfiles.getUrl$suspendImpl(Krakenfiles.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Krakenfiles $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00361 c00361;
        List groupValues;
        String id;
        String id2;
        Continuation continuation2;
        Object obj;
        Object obj2;
        Krakenfiles $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String link;
        Object objNewExtractorLink$default;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00361) {
            c00361 = (C00361) continuation;
            if ((c00361.label & Integer.MIN_VALUE) != 0) {
                c00361.label -= Integer.MIN_VALUE;
            } else {
                c00361 = $this.new C00361(continuation);
            }
        } else {
            c00361 = $this.new C00361(continuation);
        }
        C00361 c00362 = c00361;
        Object $result = c00362.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00362.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MatchResult matchResultFind$default = Regex.find$default(new Regex("/(?:view|embed-video)/([\\da-zA-Z]+)"), url, 0, 2, (Object) null);
                if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (id = (String) groupValues.get(1)) == null) {
                    return Unit.INSTANCE;
                }
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + "/embed-video/" + id;
                c00362.L$0 = $this;
                c00362.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00362.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00362.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00362.L$4 = function2;
                c00362.L$5 = SpillingKt.nullOutSpilledVariable(id);
                c00362.label = 1;
                id2 = id;
                continuation2 = null;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00362, 4094, (Object) null);
                if (obj2 == obj) {
                    c00362 = c00362;
                    return obj;
                }
                c00362 = c00362;
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                Document doc = ((NiceResponse) obj2).getDocument();
                String title = doc.select("span.coin-name").text();
                elementSelectFirst = doc.selectFirst("source");
                if (elementSelectFirst != null || (link = elementSelectFirst.attr("src")) == null) {
                    return Unit.INSTANCE;
                }
                int quality = StreamPlayUtilsKt.getIndexQuality(title);
                String name = $this2.getName();
                String name2 = $this2.getName();
                String strHttpsify = ExtractorApiKt.httpsify(link);
                C00372 c00372 = new C00372(quality, continuation2);
                c00362.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00362.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00362.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00362.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00362.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00362.L$5 = SpillingKt.nullOutSpilledVariable(id2);
                c00362.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                c00362.L$7 = SpillingKt.nullOutSpilledVariable(title);
                c00362.L$8 = SpillingKt.nullOutSpilledVariable(link);
                c00362.L$9 = function4;
                c00362.I$0 = quality;
                c00362.label = 2;
                objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(name, name2, strHttpsify, (ExtractorLinkType) null, c00372, c00362, 8, (Object) null);
                if (objNewExtractorLink$default == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink$default);
                return Unit.INSTANCE;
            case 1:
                String id3 = (String) c00362.L$5;
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00362.L$4;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00362.L$3;
                String referer3 = (String) c00362.L$2;
                String url3 = (String) c00362.L$1;
                Krakenfiles $this3 = (Krakenfiles) c00362.L$0;
                ResultKt.throwOnFailure($result);
                id2 = id3;
                continuation2 = null;
                function4 = function6;
                function3 = function7;
                referer2 = referer3;
                url2 = url3;
                $this2 = $this3;
                obj = coroutine_suspended;
                obj2 = $result;
                Document doc2 = ((NiceResponse) obj2).getDocument();
                String title2 = doc2.select("span.coin-name").text();
                elementSelectFirst = doc2.selectFirst("source");
                if (elementSelectFirst != null) {
                }
                return Unit.INSTANCE;
            case 2:
                int i = c00362.I$0;
                function5 = (Function1) c00362.L$9;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink$default = $result;
                function5.invoke(objNewExtractorLink$default);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Krakenfiles$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Krakenfiles$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00372 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00372(int i, Continuation<? super C00372> continuation) {
            super(2, continuation);
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00372 = new C00372(this.$quality, continuation);
            c00372.L$0 = obj;
            return c00372;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
