package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.network.CloudflareKiller;
import com.lagradost.cloudstream3.utils.ExtractorApi;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/OFile;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class OFile extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "OXXFile";

    @NotNull
    private final String mainUrl = "https://new.oxxfile.info";

    /* JADX INFO: renamed from: com.phisher98.OFile$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.OFile", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1199, 1208, 1214}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "cf", "url", "referer", "subtitleCallback", "callback", "cf", "redirectedUrl", "baseDomain", "id", "idIndex", "url", "referer", "subtitleCallback", "callback", "cf", "redirectedUrl", "baseDomain", "id", "hubcloudUrl", "idIndex"}, nl = {1201, 1211, 1220}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00501 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00501(Continuation<? super C00501> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OFile.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:21:0x0132  */
    /* JADX WARN: Code duplicated, block: B:23:0x0135  */
    /* JADX WARN: Code duplicated, block: B:25:0x0159  */
    /* JADX WARN: Code duplicated, block: B:26:0x015c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0160  */
    /* JADX WARN: Code duplicated, block: B:30:0x0163  */
    /* JADX WARN: Code duplicated, block: B:32:0x01e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:36:0x0200  */
    /* JADX WARN: Code duplicated, block: B:37:0x0202  */
    /* JADX WARN: Code duplicated, block: B:40:0x0246 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00501 c00501;
        Object obj;
        C00501 c00502;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        CloudflareKiller cf;
        String url2;
        String referer2;
        String redirectedUrl;
        int idIndex;
        String baseDomain;
        String id;
        boolean z;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        String referer3;
        C00501 c00503;
        String id2;
        String url3;
        CloudflareKiller cf2;
        int idIndex2;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        String redirectedUrl2;
        String referer4;
        String baseDomain2;
        String hubcloudUrl;
        String str;
        if (continuation instanceof C00501) {
            c00501 = (C00501) continuation;
            if ((c00501.label & Integer.MIN_VALUE) != 0) {
                c00501.label -= Integer.MIN_VALUE;
            } else {
                c00501 = new C00501(continuation);
            }
        } else {
            c00501 = new C00501(continuation);
        }
        Object $result = c00501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00501.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CloudflareKiller cf3 = new CloudflareKiller();
                c00501.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00501.L$1 = referer;
                c00501.L$2 = function1;
                c00501.L$3 = function2;
                c00501.L$4 = cf3;
                c00501.label = 1;
                C00501 c00504 = c00501;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(MainActivityKt.getApp(), url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) cf3, false, (ResponseParser) null, c00504, 3582, (Object) null);
                c00502 = c00504;
                if (obj3 == obj) {
                    return obj;
                }
                function3 = function1;
                function4 = function2;
                obj2 = obj3;
                cf = cf3;
                url2 = url;
                referer2 = referer;
                redirectedUrl = ((NiceResponse) obj2).getUrl();
                idIndex = StringsKt.indexOf$default(redirectedUrl, "/s/", 0, false, 6, (Object) null);
                if (idIndex == -1) {
                    return Unit.INSTANCE;
                }
                baseDomain = redirectedUrl.substring(0, idIndex);
                Intrinsics.checkNotNullExpressionValue(baseDomain, "substring(...)");
                String strSubstring = redirectedUrl.substring(idIndex + 3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                id = StringsKt.substringBefore$default(strSubstring, '/', (String) null, 2, (Object) null);
                if (id.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                c00502.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00502.L$1 = referer2;
                c00502.L$2 = function3;
                c00502.L$3 = function4;
                c00502.L$4 = SpillingKt.nullOutSpilledVariable(cf);
                c00502.L$5 = SpillingKt.nullOutSpilledVariable(redirectedUrl);
                c00502.L$6 = baseDomain;
                c00502.L$7 = SpillingKt.nullOutSpilledVariable(id);
                c00502.I$0 = idIndex;
                c00502.label = 2;
                function5 = function3;
                function6 = function4;
                referer3 = referer2;
                C00501 c00505 = c00502;
                $result = Requests.get$default(MainActivityKt.getApp(), baseDomain + "/api/s/" + id + "/hubcloud", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) cf, false, (ResponseParser) null, c00505, 3582, (Object) null);
                c00503 = c00505;
                if ($result == obj) {
                    return obj;
                }
                id2 = id;
                url3 = url2;
                cf2 = cf;
                idIndex2 = idIndex;
                function7 = function5;
                function8 = function6;
                redirectedUrl2 = redirectedUrl;
                referer4 = referer3;
                baseDomain2 = baseDomain;
                hubcloudUrl = ((NiceResponse) $result).getUrl();
                if (referer4 == null) {
                    str = baseDomain2;
                } else {
                    str = referer4;
                }
                c00503.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00503.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                c00503.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00503.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00503.L$4 = SpillingKt.nullOutSpilledVariable(cf2);
                c00503.L$5 = SpillingKt.nullOutSpilledVariable(redirectedUrl2);
                c00503.L$6 = SpillingKt.nullOutSpilledVariable(baseDomain2);
                c00503.L$7 = SpillingKt.nullOutSpilledVariable(id2);
                c00503.L$8 = SpillingKt.nullOutSpilledVariable(hubcloudUrl);
                c00503.I$0 = idIndex2;
                c00503.label = 3;
                if (ExtractorApiKt.loadExtractor(hubcloudUrl, str, function7, function8, c00503) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                CloudflareKiller cf4 = (CloudflareKiller) c00501.L$4;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00501.L$3;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00501.L$2;
                String referer5 = (String) c00501.L$1;
                String url4 = (String) c00501.L$0;
                ResultKt.throwOnFailure($result);
                c00502 = c00501;
                obj = coroutine_suspended;
                cf = cf4;
                function4 = function9;
                function3 = function10;
                url2 = url4;
                obj2 = $result;
                referer2 = referer5;
                redirectedUrl = ((NiceResponse) obj2).getUrl();
                idIndex = StringsKt.indexOf$default(redirectedUrl, "/s/", 0, false, 6, (Object) null);
                if (idIndex == -1) {
                    return Unit.INSTANCE;
                }
                baseDomain = redirectedUrl.substring(0, idIndex);
                Intrinsics.checkNotNullExpressionValue(baseDomain, "substring(...)");
                String strSubstring2 = redirectedUrl.substring(idIndex + 3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                id = StringsKt.substringBefore$default(strSubstring2, '/', (String) null, 2, (Object) null);
                if (id.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                c00502.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00502.L$1 = referer2;
                c00502.L$2 = function3;
                c00502.L$3 = function4;
                c00502.L$4 = SpillingKt.nullOutSpilledVariable(cf);
                c00502.L$5 = SpillingKt.nullOutSpilledVariable(redirectedUrl);
                c00502.L$6 = baseDomain;
                c00502.L$7 = SpillingKt.nullOutSpilledVariable(id);
                c00502.I$0 = idIndex;
                c00502.label = 2;
                function5 = function3;
                function6 = function4;
                referer3 = referer2;
                C00501 c00506 = c00502;
                $result = Requests.get$default(MainActivityKt.getApp(), baseDomain + "/api/s/" + id + "/hubcloud", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) cf, false, (ResponseParser) null, c00506, 3582, (Object) null);
                c00503 = c00506;
                if ($result == obj) {
                    return obj;
                }
                id2 = id;
                url3 = url2;
                cf2 = cf;
                idIndex2 = idIndex;
                function7 = function5;
                function8 = function6;
                redirectedUrl2 = redirectedUrl;
                referer4 = referer3;
                baseDomain2 = baseDomain;
                hubcloudUrl = ((NiceResponse) $result).getUrl();
                if (referer4 == null) {
                    str = baseDomain2;
                } else {
                    str = referer4;
                }
                c00503.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00503.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                c00503.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00503.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00503.L$4 = SpillingKt.nullOutSpilledVariable(cf2);
                c00503.L$5 = SpillingKt.nullOutSpilledVariable(redirectedUrl2);
                c00503.L$6 = SpillingKt.nullOutSpilledVariable(baseDomain2);
                c00503.L$7 = SpillingKt.nullOutSpilledVariable(id2);
                c00503.L$8 = SpillingKt.nullOutSpilledVariable(hubcloudUrl);
                c00503.I$0 = idIndex2;
                c00503.label = 3;
                if (ExtractorApiKt.loadExtractor(hubcloudUrl, str, function7, function8, c00503) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                idIndex2 = c00501.I$0;
                id2 = (String) c00501.L$7;
                baseDomain2 = (String) c00501.L$6;
                redirectedUrl2 = (String) c00501.L$5;
                cf2 = (CloudflareKiller) c00501.L$4;
                function8 = (Function1) c00501.L$3;
                function7 = (Function1) c00501.L$2;
                referer4 = (String) c00501.L$1;
                url3 = (String) c00501.L$0;
                ResultKt.throwOnFailure($result);
                c00503 = c00501;
                obj = coroutine_suspended;
                hubcloudUrl = ((NiceResponse) $result).getUrl();
                if (referer4 == null) {
                    str = baseDomain2;
                } else {
                    str = referer4;
                }
                c00503.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00503.L$1 = SpillingKt.nullOutSpilledVariable(referer4);
                c00503.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00503.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                c00503.L$4 = SpillingKt.nullOutSpilledVariable(cf2);
                c00503.L$5 = SpillingKt.nullOutSpilledVariable(redirectedUrl2);
                c00503.L$6 = SpillingKt.nullOutSpilledVariable(baseDomain2);
                c00503.L$7 = SpillingKt.nullOutSpilledVariable(id2);
                c00503.L$8 = SpillingKt.nullOutSpilledVariable(hubcloudUrl);
                c00503.I$0 = idIndex2;
                c00503.label = 3;
                if (ExtractorApiKt.loadExtractor(hubcloudUrl, str, function7, function8, c00503) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 3:
                int i = c00501.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
