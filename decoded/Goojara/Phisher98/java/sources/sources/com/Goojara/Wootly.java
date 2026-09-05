package com.Goojara;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Goojara/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/Goojara/Wootly;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Wootly extends ExtractorApi {

    @NotNull
    private String name = "Wootly";

    @NotNull
    private String mainUrl = "https://www.wootly.ch";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Goojara.Wootly$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Wootly", f = "Extractor.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {102, 105, 115, 118}, m = "getUrl", n = {"url", "referer", "url", "referer", "iframe", "body", "url", "referer", "iframe", "body", "iframeResp", "iframeHtml", "vdRegex", "tkRegex", "vd", "tk", "url", "referer", "iframe", "body", "iframeResp", "iframeHtml", "vdRegex", "tkRegex", "vd", "tk", "iframeurl"}, nl = {103, 106, 118, 117}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00101 extends ContinuationImpl {
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

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Wootly.this.getUrl(null, null, (Continuation) this);
        }
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

    /* JADX WARN: Code duplicated, block: B:22:0x01a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:26:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:29:0x01de  */
    /* JADX WARN: Code duplicated, block: B:32:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:35:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:38:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:42:0x0208  */
    /* JADX WARN: Code duplicated, block: B:44:0x020b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0210  */
    /* JADX WARN: Code duplicated, block: B:51:0x021a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0226  */
    /* JADX WARN: Code duplicated, block: B:54:0x02b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:58:0x0329 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x032a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0334  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        C00101 c00101;
        Wootly wootly;
        Object obj;
        int i;
        String url2;
        Object obj2;
        String referer2;
        String iframe;
        Map body;
        String referer3;
        Object objPost$default;
        String iframe2;
        Map body2;
        String referer4;
        NiceResponse iframeResp;
        String iframeHtml;
        Regex vdRegex;
        Regex tkRegex;
        MatchResult matchResultFind$default;
        String vd;
        MatchResult matchResultFind$default2;
        boolean z;
        String tk;
        String str;
        boolean z2;
        String str2;
        String referer5;
        Regex tkRegex2;
        String vd2;
        Regex vdRegex2;
        Object obj3;
        Map body3;
        String iframe3;
        NiceResponse iframeResp2;
        String iframeHtml2;
        String referer6;
        String iframe4;
        List groupValues;
        List groupValues2;
        Object objNewExtractorLink;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
                wootly = this;
            } else {
                wootly = this;
                c00101 = wootly.new C00101(continuation);
            }
        } else {
            wootly = this;
            c00101 = wootly.new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00102.L$1 = referer;
                c00102.label = 1;
                obj = coroutine_suspended;
                i = 2;
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4094, (Object) null);
                c00102 = c00102;
                if (obj4 == obj) {
                    return obj;
                }
                url2 = url;
                obj2 = obj4;
                referer2 = referer;
                iframe = ((NiceResponse) obj2).getDocument().select("iframe").attr("src");
                body = MapsKt.mapOf(TuplesKt.to("qdfx", "1"));
                Requests app2 = MainActivityKt.getApp();
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.L$1 = referer2;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00102.label = i;
                referer3 = referer2;
                C00101 c00103 = c00102;
                objPost$default = Requests.post$default(app2, iframe, (Map) null, (String) null, (Map) null, (Map) null, body, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00103, 65502, (Object) null);
                c00102 = c00103;
                if (objPost$default == obj) {
                    return obj;
                }
                iframe2 = iframe;
                body2 = body;
                referer4 = referer3;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                    vd = null;
                } else {
                    vd = (String) groupValues2.get(1);
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                    z = true;
                    tk = null;
                } else {
                    z = true;
                    tk = (String) groupValues.get(1);
                }
                str = vd;
                if (str != null || StringsKt.isBlank(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return null;
                }
                str2 = tk;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.L$1 = referer4;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.label = 3;
                C00101 c00104 = c00102;
                referer5 = referer4;
                tkRegex2 = tkRegex;
                vd2 = vd;
                vdRegex2 = vdRegex;
                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + tk + "&id=" + vd, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00104, 4094, (Object) null);
                c00102 = c00104;
                if (obj3 == obj) {
                    return obj;
                }
                body3 = body2;
                iframe3 = iframe2;
                iframeResp2 = iframeResp;
                iframeHtml2 = iframeHtml;
                referer6 = url2;
                iframe4 = referer5;
                String iframeurl = ((NiceResponse) obj3).getText();
                String name = wootly.getName();
                String name2 = wootly.getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00112 c00112 = new C00112(iframe4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body3);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml2);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd2);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl);
                c00102.label = 4;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, iframeurl, infer_type, c00112, c00102);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 1:
                String referer7 = (String) c00102.L$1;
                String url3 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                referer2 = referer7;
                url2 = url3;
                obj2 = $result;
                i = 2;
                iframe = ((NiceResponse) obj2).getDocument().select("iframe").attr("src");
                body = MapsKt.mapOf(TuplesKt.to("qdfx", "1"));
                Requests app3 = MainActivityKt.getApp();
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.L$1 = referer2;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c00102.label = i;
                referer3 = referer2;
                C00101 c00105 = c00102;
                objPost$default = Requests.post$default(app3, iframe, (Map) null, (String) null, (Map) null, (Map) null, body, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00105, 65502, (Object) null);
                c00102 = c00105;
                if (objPost$default == obj) {
                    return obj;
                }
                iframe2 = iframe;
                body2 = body;
                referer4 = referer3;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    vd = null;
                } else {
                    vd = null;
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default2 != null) {
                    z = true;
                    tk = null;
                } else {
                    z = true;
                    tk = null;
                }
                str = vd;
                if (str != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    return null;
                }
                str2 = tk;
                if (str2 != null) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.L$1 = referer4;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.label = 3;
                C00101 c00106 = c00102;
                referer5 = referer4;
                tkRegex2 = tkRegex;
                vd2 = vd;
                vdRegex2 = vdRegex;
                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + tk + "&id=" + vd, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00106, 4094, (Object) null);
                c00102 = c00106;
                if (obj3 == obj) {
                    return obj;
                }
                body3 = body2;
                iframe3 = iframe2;
                iframeResp2 = iframeResp;
                iframeHtml2 = iframeHtml;
                referer6 = url2;
                iframe4 = referer5;
                String iframeurl2 = ((NiceResponse) obj3).getText();
                String name3 = wootly.getName();
                String name4 = wootly.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00112 c00113 = new C00112(iframe4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body3);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml2);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd2);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl2);
                c00102.label = 4;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, iframeurl2, infer_type2, c00113, c00102);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 2:
                Map body4 = (Map) c00102.L$3;
                String iframe5 = (String) c00102.L$2;
                String referer8 = (String) c00102.L$1;
                String url4 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                body2 = body4;
                iframe2 = iframe5;
                referer4 = referer8;
                url2 = url4;
                objPost$default = $result;
                i = 2;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    vd = null;
                } else {
                    vd = null;
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, (Object) null);
                if (matchResultFind$default2 != null) {
                    z = true;
                    tk = null;
                } else {
                    z = true;
                    tk = null;
                }
                str = vd;
                if (str != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    return null;
                }
                str2 = tk;
                if (str2 != null) {
                    z = false;
                }
                if (z) {
                    return null;
                }
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.L$1 = referer4;
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.label = 3;
                C00101 c00107 = c00102;
                referer5 = referer4;
                tkRegex2 = tkRegex;
                vd2 = vd;
                vdRegex2 = vdRegex;
                obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + tk + "&id=" + vd, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00107, 4094, (Object) null);
                c00102 = c00107;
                if (obj3 == obj) {
                    return obj;
                }
                body3 = body2;
                iframe3 = iframe2;
                iframeResp2 = iframeResp;
                iframeHtml2 = iframeHtml;
                referer6 = url2;
                iframe4 = referer5;
                String iframeurl3 = ((NiceResponse) obj3).getText();
                String name5 = wootly.getName();
                String name6 = wootly.getName();
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                C00112 c00114 = new C00112(iframe4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body3);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml2);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd2);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl3);
                c00102.label = 4;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, iframeurl3, infer_type3, c00114, c00102);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 3:
                String tk2 = (String) c00102.L$9;
                String vd3 = (String) c00102.L$8;
                Regex tkRegex3 = (Regex) c00102.L$7;
                Regex vdRegex3 = (Regex) c00102.L$6;
                String iframeHtml3 = (String) c00102.L$5;
                NiceResponse iframeResp3 = (NiceResponse) c00102.L$4;
                Map body5 = (Map) c00102.L$3;
                String iframe6 = (String) c00102.L$2;
                String referer9 = (String) c00102.L$1;
                String url5 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                vd2 = vd3;
                tkRegex2 = tkRegex3;
                vdRegex2 = vdRegex3;
                iframeHtml2 = iframeHtml3;
                iframeResp2 = iframeResp3;
                body3 = body5;
                iframe3 = iframe6;
                iframe4 = referer9;
                referer6 = url5;
                obj3 = $result;
                tk = tk2;
                String iframeurl4 = ((NiceResponse) obj3).getText();
                String name7 = wootly.getName();
                String name8 = wootly.getName();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                C00112 c00115 = new C00112(iframe4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(body3);
                c00102.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                c00102.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml2);
                c00102.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                c00102.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                c00102.L$8 = SpillingKt.nullOutSpilledVariable(vd2);
                c00102.L$9 = SpillingKt.nullOutSpilledVariable(tk);
                c00102.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl4);
                c00102.label = 4;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, iframeurl4, infer_type4, c00115, c00102);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                return CollectionsKt.listOf(objNewExtractorLink);
            case 4:
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                return CollectionsKt.listOf(objNewExtractorLink);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Wootly$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Wootly$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(String str, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$referer = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(this.$referer, continuation);
            c00112.L$0 = obj;
            return c00112;
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
                    String str = this.$referer;
                    if (str == null) {
                        str = "";
                    }
                    $this$newExtractorLink.setReferer(str);
                    $this$newExtractorLink.setQuality(Qualities.P720.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
