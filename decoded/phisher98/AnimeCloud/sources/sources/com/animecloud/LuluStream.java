package com.animecloud;

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
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/animecloud/LuluStream;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class LuluStream extends ExtractorApi {

    @NotNull
    private String name = "LuluStream";

    @NotNull
    private String mainUrl = "https://luluvdo.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.animecloud.LuluStream$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.LuluStream", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {53, 66}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "filecode", "postUrl", "$this", "url", "referer", "subtitleCallback", "callback", "filecode", "postUrl", "post", "script", "link"}, nl = {61, 65}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LuluStream.getUrl$suspendImpl(LuluStream.this, null, null, null, null, (Continuation) this);
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

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(LuluStream $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00081 c00081;
        String filecode;
        Object obj;
        int i;
        int i2;
        Object objPost$default;
        LuluStream $this2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String postUrl;
        Element elementSelectFirst;
        String script;
        MatchResult matchResultFind$default;
        List groupValues;
        String link;
        Object objNewExtractorLink;
        LuluStream $this3;
        Function1<? super ExtractorLink, Unit> function5;
        Document post;
        String script2;
        int i3;
        String url3;
        String postUrl2;
        Function1<? super SubtitleFile, Unit> function6;
        String postUrl3;
        String filecode2;
        Function1<? super ExtractorLink, Unit> function7;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = $this.new C00081(continuation);
            }
        } else {
            c00081 = $this.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String filecode3 = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                String postUrl4 = $this.getMainUrl() + "/dl";
                Requests app = MainActivityKt.getApp();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("op", "embed");
                pairArr[1] = TuplesKt.to("file_code", filecode3);
                pairArr[2] = TuplesKt.to("auto", "1");
                pairArr[3] = TuplesKt.to("referer", referer == null ? "" : referer);
                Map mapMapOf = MapsKt.mapOf(pairArr);
                c00082.L$0 = $this;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00082.L$4 = function2;
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(filecode3);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(postUrl4);
                c00082.label = 1;
                filecode = filecode3;
                obj = coroutine_suspended;
                i = 0;
                i2 = 2;
                objPost$default = Requests.post$default(app, postUrl4, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65502, (Object) null);
                c00082 = c00082;
                if (objPost$default == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                postUrl = postUrl4;
                Document post2 = ((NiceResponse) objPost$default).getDocument();
                elementSelectFirst = post2.selectFirst("script:containsData(vplayer)");
                if (elementSelectFirst == null && (script = elementSelectFirst.data()) != null && (matchResultFind$default = Regex.find$default(new Regex("file:\"(.*)\""), script, i, i2, (Object) null)) != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (link = (String) groupValues.get(1)) != null) {
                    String name = $this2.getName();
                    String name2 = $this2.getName();
                    ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                    LuluStream$getUrl$2$1$1 luluStream$getUrl$2$1$1 = new LuluStream$getUrl$2$1$1($this2, null);
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(filecode);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(postUrl);
                    c00082.L$7 = SpillingKt.nullOutSpilledVariable(post2);
                    c00082.L$8 = SpillingKt.nullOutSpilledVariable(script);
                    c00082.L$9 = SpillingKt.nullOutSpilledVariable(link);
                    c00082.L$10 = function4;
                    c00082.label = i2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, link, infer_type, luluStream$getUrl$2$1$1, c00082);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    $this3 = $this2;
                    function5 = function4;
                    post = post2;
                    script2 = script;
                    i3 = 0;
                    url3 = url2;
                    postUrl2 = postUrl;
                    function6 = function3;
                    postUrl3 = referer2;
                    filecode2 = filecode;
                    function7 = function5;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                String postUrl5 = (String) c00082.L$6;
                String filecode4 = (String) c00082.L$5;
                function4 = (Function1) c00082.L$4;
                function3 = (Function1) c00082.L$3;
                referer2 = (String) c00082.L$2;
                url2 = (String) c00082.L$1;
                LuluStream $this4 = (LuluStream) c00082.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this4;
                postUrl = postUrl5;
                obj = coroutine_suspended;
                filecode = filecode4;
                i = 0;
                objPost$default = $result;
                i2 = 2;
                Document post3 = ((NiceResponse) objPost$default).getDocument();
                elementSelectFirst = post3.selectFirst("script:containsData(vplayer)");
                if (elementSelectFirst == null) {
                }
                return Unit.INSTANCE;
            case 2:
                i3 = 0;
                function5 = (Function1) c00082.L$10;
                script2 = (String) c00082.L$8;
                post = (Document) c00082.L$7;
                postUrl2 = (String) c00082.L$6;
                filecode2 = (String) c00082.L$5;
                function7 = (Function1) c00082.L$4;
                function6 = (Function1) c00082.L$3;
                postUrl3 = (String) c00082.L$2;
                url3 = (String) c00082.L$1;
                $this3 = (LuluStream) c00082.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
