package com.Coflix;

import com.lagradost.cloudstream3.MainActivityKt;
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
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Coflix/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/Coflix/darkibox;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Coflix"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class darkibox extends ExtractorApi {

    @NotNull
    private String name = "Darkibox";

    @NotNull
    private String mainUrl = "https://darkibox.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Coflix.darkibox$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.darkibox", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {25, 28}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "$this", "url", "referer", "response", "link"}, nl = {26, 27}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return darkibox.getUrl$suspendImpl(darkibox.this, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, continuation);
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
    static /* synthetic */ Object getUrl$suspendImpl(darkibox $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00141 c00141;
        Object obj;
        int i;
        Object obj2;
        darkibox $this2;
        String url2;
        String referer2;
        MatchResult matchResultFind$default;
        List groupValues;
        String link;
        Object objNewExtractorLink;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = $this.new C00141(continuation);
            }
        } else {
            c00141 = $this.new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00142.L$0 = $this;
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00142.L$2 = referer;
                c00142.label = 1;
                obj = coroutine_suspended;
                i = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4094, (Object) null);
                c00142 = c00142;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                String response = ((NiceResponse) obj2).toString();
                matchResultFind$default = Regex.find$default(new Regex("sources:\\s*\\[\\{src:\\s*\"(.*?)\""), response, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (link = (String) groupValues.get(i)) == null) {
                    return null;
                }
                String name = $this2.getName();
                String name2 = $this2.getName();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                darkibox$getUrl$2$1 darkibox_geturl_2_1 = new darkibox$getUrl$2$1(referer2, null);
                c00142.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00142.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00142.L$3 = SpillingKt.nullOutSpilledVariable(response);
                c00142.L$4 = SpillingKt.nullOutSpilledVariable(link);
                c00142.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, link, extractorLinkType, darkibox_geturl_2_1, c00142);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 1:
                String referer3 = (String) c00142.L$2;
                String url3 = (String) c00142.L$1;
                darkibox $this3 = (darkibox) c00142.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                referer2 = referer3;
                url2 = url3;
                i = 1;
                obj2 = $result;
                String response2 = ((NiceResponse) obj2).toString();
                matchResultFind$default = Regex.find$default(new Regex("sources:\\s*\\[\\{src:\\s*\"(.*?)\""), response2, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    break;
                }
                return null;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                return CollectionsKt.listOf(objNewExtractorLink);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
