package com.Animexin;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.JsUnpacker;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animexin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/Animexin/Vtbe;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animexin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class Vtbe extends ExtractorApi {

    @NotNull
    private String name = "Vtbe";

    @NotNull
    private String mainUrl = "https://vtbe.to";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Animexin.Vtbe$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Vtbe", f = "Extractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {22, 27}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "$this", "url", "referer", "response", "extractedpack", "unPacked", "link"}, nl = {23, 26}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Vtbe.getUrl$suspendImpl(Vtbe.this, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:20:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:21:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Vtbe $this, String url, String referer, Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00121 c00121;
        Object obj;
        int i;
        Object obj2;
        Vtbe $this2;
        String url2;
        String referer2;
        Element elementSelectFirst;
        String strData;
        String unPacked;
        MatchResult matchResultFind$default;
        List groupValues;
        String link;
        Object objNewExtractorLink;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = $this.new C00121(continuation);
            }
        } else {
            c00121 = $this.new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String mainUrl = $this.getMainUrl();
                c00122.L$0 = $this;
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00122.L$2 = referer;
                c00122.label = 1;
                obj = coroutine_suspended;
                i = 1;
                obj2 = Requests.get$default(app, url, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 4090, (Object) null);
                c00122 = c00122;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                referer2 = referer;
                Document response = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = response.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                String extractedpack = String.valueOf(strData);
                unPacked = new JsUnpacker(extractedpack).unpack();
                if (unPacked != null || (matchResultFind$default = Regex.find$default(new Regex("sources:\\[\\{file:\"(.*?)\""), unPacked, 0, 2, (Object) null)) == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (link = (String) groupValues.get(i)) == null) {
                    return null;
                }
                String name = $this2.getName();
                String name2 = $this2.getName();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                Vtbe$getUrl$2$1$1 vtbe$getUrl$2$1$1 = new Vtbe$getUrl$2$1$1(referer2, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(response);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(extractedpack);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(unPacked);
                c00122.L$6 = SpillingKt.nullOutSpilledVariable(link);
                c00122.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, link, extractorLinkType, vtbe$getUrl$2$1$1, c00122);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 1:
                String referer3 = (String) c00122.L$2;
                String url3 = (String) c00122.L$1;
                Vtbe $this3 = (Vtbe) c00122.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                referer2 = referer3;
                url2 = url3;
                i = 1;
                obj2 = $result;
                Document response2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = response2.selectFirst("script:containsData(function(p,a,c,k,e,d))");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                String extractedpack2 = String.valueOf(strData);
                unPacked = new JsUnpacker(extractedpack2).unpack();
                if (unPacked != null) {
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
