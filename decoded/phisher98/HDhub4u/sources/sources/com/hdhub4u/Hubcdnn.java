package com.hdhub4u;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/hdhub4u/Hubcdnn;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Hubcdnn extends ExtractorApi {

    @NotNull
    private final String name = "Hubcdn";

    @NotNull
    private final String mainUrl = "https://hubcdn.*";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.hdhub4u.Hubcdnn$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.Hubcdnn", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {165, 170}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "it", "m3u8", "encoded"}, nl = {166, 169}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hubcdnn.this.getUrl(null, null, null, null, (Continuation) this);
        }
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

    /* JADX WARN: Code duplicated, block: B:25:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:29:0x0104  */
    /* JADX WARN: Code duplicated, block: B:31:0x010a  */
    /* JADX WARN: Code duplicated, block: B:33:0x010d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0164 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0165  */
    /* JADX WARN: Code duplicated, block: B:38:0x017c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00141 c00141;
        Hubcdnn hubcdnn;
        Object obj;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String it;
        MatchResult matchResultFind$default;
        String value;
        String encoded;
        String str;
        Object objNewExtractorLink;
        String referer3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        String it2;
        String m3u8;
        String url3;
        Function1<? super ExtractorLink, Unit> function7;
        MatchGroupCollection groups;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
                hubcdnn = this;
            } else {
                hubcdnn = this;
                c00141 = hubcdnn.new C00141(continuation);
            }
        } else {
            hubcdnn = this;
            c00141 = hubcdnn.new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00142.L$0 = url;
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00142.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00142.L$3 = function2;
                c00142.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4094, (Object) null);
                c00142 = c00142;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                it = ((NiceResponse) obj2).getDocument().toString();
                matchResultFind$default = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), it, 0, 2, (Object) null);
                if (matchResultFind$default == null && (groups = matchResultFind$default.getGroups()) != null) {
                    MatchGroup matchGroup = groups.get(1);
                    if (matchGroup != null) {
                        value = matchGroup.getValue();
                    }
                    encoded = value;
                    str = encoded;
                    if (str != null || str.length() == 0) {
                        Log.INSTANCE.e("Error", "Encoded URL not found");
                    } else {
                        String m3u9 = StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null);
                        String name = hubcdnn.getName();
                        String name2 = hubcdnn.getName();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        Hubcdnn$getUrl$2$1 hubcdnn$getUrl$2$1 = new Hubcdnn$getUrl$2$1(url2, null);
                        c00142.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00142.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00142.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                        c00142.L$4 = SpillingKt.nullOutSpilledVariable(it);
                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(m3u9);
                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                        c00142.L$7 = function4;
                        c00142.label = 2;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, m3u9, extractorLinkType, hubcdnn$getUrl$2$1, c00142);
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        Function1<? super SubtitleFile, Unit> function8 = function3;
                        referer3 = referer2;
                        function5 = function8;
                        function6 = function4;
                        it2 = it;
                        m3u8 = encoded;
                        url3 = url2;
                        function7 = function6;
                        function6.invoke(objNewExtractorLink);
                    }
                    return Unit.INSTANCE;
                }
                encoded = value;
                str = encoded;
                if (str != null || str.length() == 0) {
                    String m3u10 = StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null);
                    String name3 = hubcdnn.getName();
                    String name4 = hubcdnn.getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    Hubcdnn$getUrl$2$1 hubcdnn$getUrl$2$2 = new Hubcdnn$getUrl$2$1(url2, null);
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(it);
                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(m3u10);
                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                    c00142.L$7 = function4;
                    c00142.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, m3u10, extractorLinkType2, hubcdnn$getUrl$2$2, c00142);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    Function1<? super SubtitleFile, Unit> function9 = function3;
                    referer3 = referer2;
                    function5 = function9;
                    function6 = function4;
                    it2 = it;
                    m3u8 = encoded;
                    url3 = url2;
                    function7 = function6;
                    function6.invoke(objNewExtractorLink);
                } else {
                    Log.INSTANCE.e("Error", "Encoded URL not found");
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00142.L$3;
                Function1<? super SubtitleFile, Unit> function11 = (Function1) c00142.L$2;
                String referer4 = (String) c00142.L$1;
                url2 = (String) c00142.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                function4 = function10;
                function3 = function11;
                referer2 = referer4;
                obj2 = $result;
                it = ((NiceResponse) obj2).getDocument().toString();
                matchResultFind$default = Regex.find$default(new Regex("r=([A-Za-z0-9+/=]+)"), it, 0, 2, (Object) null);
                value = matchResultFind$default == null ? null : null;
                encoded = value;
                str = encoded;
                if (str != null || str.length() == 0) {
                    String m3u11 = StringsKt.substringAfterLast$default(MainAPIKt.base64Decode(encoded), "link=", (String) null, 2, (Object) null);
                    String name5 = hubcdnn.getName();
                    String name6 = hubcdnn.getName();
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                    Hubcdnn$getUrl$2$1 hubcdnn$getUrl$2$3 = new Hubcdnn$getUrl$2$1(url2, null);
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(it);
                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(m3u11);
                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                    c00142.L$7 = function4;
                    c00142.label = 2;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, m3u11, extractorLinkType3, hubcdnn$getUrl$2$3, c00142);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    Function1<? super SubtitleFile, Unit> function12 = function3;
                    referer3 = referer2;
                    function5 = function12;
                    function6 = function4;
                    it2 = it;
                    m3u8 = encoded;
                    url3 = url2;
                    function7 = function6;
                    function6.invoke(objNewExtractorLink);
                } else {
                    Log.INSTANCE.e("Error", "Encoded URL not found");
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00142.L$7;
                m3u8 = (String) c00142.L$6;
                it2 = (String) c00142.L$4;
                function7 = (Function1) c00142.L$3;
                function5 = (Function1) c00142.L$2;
                referer3 = (String) c00142.L$1;
                url3 = (String) c00142.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function6.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
