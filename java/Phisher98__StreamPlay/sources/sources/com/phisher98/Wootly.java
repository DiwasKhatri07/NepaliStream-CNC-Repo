package com.phisher98;

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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/phisher98/Wootly;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Wootly extends ExtractorApi {

    @NotNull
    private String name = "Wootly";

    @NotNull
    private String mainUrl = "https://www.wootly.ch";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Wootly$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Wootly", f = "Extractors.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {3269, 3274, 3284, 3287}, m = "getUrl", n = {"url", "referer", "url", "referer", "iframe", "body", "url", "referer", "iframe", "body", "iframeResp", "iframeHtml", "vdRegex", "tkRegex", "vd", "tk", "url", "referer", "iframe", "body", "iframeResp", "iframeHtml", "vdRegex", "tkRegex", "vd", "tk", "iframeurl"}, nl = {3270, 3275, 3287, 3286}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C03111 extends ContinuationImpl {
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

        C03111(Continuation<? super C03111> continuation) {
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

    /* JADX WARN: Code duplicated, block: B:22:0x01b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:26:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:29:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:32:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:35:0x0200  */
    /* JADX WARN: Code duplicated, block: B:38:0x0207  */
    /* JADX WARN: Code duplicated, block: B:42:0x0210  */
    /* JADX WARN: Code duplicated, block: B:44:0x0213  */
    /* JADX WARN: Code duplicated, block: B:46:0x0218  */
    /* JADX WARN: Code duplicated, block: B:51:0x0222  */
    /* JADX WARN: Code duplicated, block: B:52:0x022e  */
    /* JADX WARN: Code duplicated, block: B:54:0x02bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0330 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0331  */
    /* JADX WARN: Code duplicated, block: B:62:0x033f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        C03111 c03111;
        Object obj;
        Continuation continuation2;
        String url2;
        Object obj2;
        String referer2;
        String iframe;
        FormBody body;
        String referer3;
        int i;
        Object objPost$default;
        String iframe2;
        String referer4;
        NiceResponse iframeResp;
        String iframeHtml;
        Regex vdRegex;
        Regex tkRegex;
        MatchResult matchResultFind$default;
        Continuation continuation3;
        MatchResult matchResultFind$default2;
        boolean z;
        Continuation continuation4;
        CharSequence charSequence;
        boolean z2;
        CharSequence charSequence2;
        String referer5;
        Regex tkRegex2;
        Continuation continuation5;
        Object obj3;
        String iframe3;
        NiceResponse iframeResp2;
        Regex vdRegex2;
        String referer6;
        FormBody body2;
        String iframe4;
        List groupValues;
        List groupValues2;
        if (continuation instanceof C03111) {
            c03111 = (C03111) continuation;
            if ((c03111.label & Integer.MIN_VALUE) != 0) {
                c03111.label -= Integer.MIN_VALUE;
            } else {
                c03111 = new C03111(continuation);
            }
        } else {
            c03111 = new C03111(continuation);
        }
        C03111 c03112 = c03111;
        Object $result = c03112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c03112.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c03112.L$1 = referer;
                c03112.label = 1;
                obj = coroutine_suspended;
                continuation2 = null;
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03112, 4094, (Object) null);
                c03112 = c03112;
                if (obj4 == obj) {
                    return obj;
                }
                url2 = url;
                obj2 = obj4;
                referer2 = referer;
                iframe = ((NiceResponse) obj2).getDocument().select("iframe").attr("src");
                body = new FormBody.Builder(continuation2, 1, continuation2).add("qdfx", "1").build();
                c03112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03112.L$1 = referer2;
                c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe);
                c03112.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c03112.label = 2;
                referer3 = referer2;
                C03111 c03113 = c03112;
                i = 2;
                objPost$default = Requests.post$default(MainActivityKt.getApp(), iframe, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03113, 65278, (Object) null);
                c03112 = c03113;
                if (objPost$default == obj) {
                    return obj;
                }
                iframe2 = iframe;
                referer4 = referer3;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) {
                    continuation3 = continuation2;
                } else {
                    continuation3 = (String) groupValues2.get(1);
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default2 != null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                    z = true;
                    continuation4 = continuation2;
                } else {
                    z = true;
                    continuation4 = (String) groupValues.get(1);
                }
                charSequence = (CharSequence) continuation3;
                if (charSequence != null || StringsKt.isBlank(charSequence)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    charSequence2 = (CharSequence) continuation4;
                    if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
                        z = false;
                    }
                    if (!z) {
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c03112.L$1 = referer4;
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation3);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.label = 3;
                        C03111 c03114 = c03112;
                        referer5 = referer4;
                        tkRegex2 = tkRegex;
                        continuation5 = continuation3;
                        obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + ((String) continuation4) + "&id=" + ((String) continuation3), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03114, 4094, (Object) null);
                        c03112 = c03114;
                        if (obj3 == obj) {
                            return obj;
                        }
                        iframe3 = iframe2;
                        iframeResp2 = iframeResp;
                        vdRegex2 = vdRegex;
                        referer6 = url2;
                        body2 = body;
                        iframe4 = referer5;
                        String iframeurl = ((NiceResponse) obj3).getText();
                        String name = getName();
                        String name2 = getName();
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        C03122 c03122 = new C03122(iframe4, continuation2);
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                        c03112.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation5);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl);
                        c03112.label = 4;
                        $result = ExtractorApiKt.newExtractorLink(name, name2, iframeurl, infer_type, c03122, c03112);
                        if ($result == obj) {
                            return obj;
                        }
                        return CollectionsKt.listOf($result);
                    }
                }
                return continuation2;
            case 1:
                String referer7 = (String) c03112.L$1;
                String url3 = (String) c03112.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                referer2 = referer7;
                url2 = url3;
                obj2 = $result;
                continuation2 = null;
                iframe = ((NiceResponse) obj2).getDocument().select("iframe").attr("src");
                body = new FormBody.Builder(continuation2, 1, continuation2).add("qdfx", "1").build();
                c03112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c03112.L$1 = referer2;
                c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe);
                c03112.L$3 = SpillingKt.nullOutSpilledVariable(body);
                c03112.label = 2;
                referer3 = referer2;
                C03111 c03115 = c03112;
                i = 2;
                objPost$default = Requests.post$default(MainActivityKt.getApp(), iframe, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03115, 65278, (Object) null);
                c03112 = c03115;
                if (objPost$default == obj) {
                    return obj;
                }
                iframe2 = iframe;
                referer4 = referer3;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default != null) {
                    continuation3 = continuation2;
                } else {
                    continuation3 = continuation2;
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default2 != null) {
                    z = true;
                    continuation4 = continuation2;
                } else {
                    z = true;
                    continuation4 = continuation2;
                }
                charSequence = (CharSequence) continuation3;
                if (charSequence != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    charSequence2 = (CharSequence) continuation4;
                    if (charSequence2 != null) {
                        z = false;
                    }
                    if (!z) {
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c03112.L$1 = referer4;
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation3);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.label = 3;
                        C03111 c03116 = c03112;
                        referer5 = referer4;
                        tkRegex2 = tkRegex;
                        continuation5 = continuation3;
                        obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + ((String) continuation4) + "&id=" + ((String) continuation3), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03116, 4094, (Object) null);
                        c03112 = c03116;
                        if (obj3 == obj) {
                            return obj;
                        }
                        iframe3 = iframe2;
                        iframeResp2 = iframeResp;
                        vdRegex2 = vdRegex;
                        referer6 = url2;
                        body2 = body;
                        iframe4 = referer5;
                        String iframeurl2 = ((NiceResponse) obj3).getText();
                        String name3 = getName();
                        String name4 = getName();
                        ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                        C03122 c03123 = new C03122(iframe4, continuation2);
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                        c03112.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation5);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl2);
                        c03112.label = 4;
                        $result = ExtractorApiKt.newExtractorLink(name3, name4, iframeurl2, infer_type2, c03123, c03112);
                        if ($result == obj) {
                            return obj;
                        }
                        return CollectionsKt.listOf($result);
                    }
                }
                return continuation2;
            case 2:
                FormBody body3 = (FormBody) c03112.L$3;
                String iframe5 = (String) c03112.L$2;
                String referer8 = (String) c03112.L$1;
                String url4 = (String) c03112.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                body = body3;
                iframe2 = iframe5;
                referer4 = referer8;
                url2 = url4;
                i = 2;
                objPost$default = $result;
                continuation2 = null;
                iframeResp = (NiceResponse) objPost$default;
                iframeHtml = iframeResp.getText();
                vdRegex = new Regex("var\\s+vd\\s*=\\s*[\"']([^\"']+)[\"']");
                tkRegex = new Regex("tk\\s*=\\s*[\"']([^\"']+)[\"']");
                matchResultFind$default = Regex.find$default(vdRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default != null) {
                    continuation3 = continuation2;
                } else {
                    continuation3 = continuation2;
                }
                matchResultFind$default2 = Regex.find$default(tkRegex, iframeHtml, 0, i, continuation2);
                if (matchResultFind$default2 != null) {
                    z = true;
                    continuation4 = continuation2;
                } else {
                    z = true;
                    continuation4 = continuation2;
                }
                charSequence = (CharSequence) continuation3;
                if (charSequence != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    charSequence2 = (CharSequence) continuation4;
                    if (charSequence2 != null) {
                        z = false;
                    }
                    if (!z) {
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c03112.L$1 = referer4;
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe2);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation3);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.label = 3;
                        C03111 c03117 = c03112;
                        referer5 = referer4;
                        tkRegex2 = tkRegex;
                        continuation5 = continuation3;
                        obj3 = Requests.get$default(MainActivityKt.getApp(), "https://web.wootly.ch/grabm?t=" + ((String) continuation4) + "&id=" + ((String) continuation3), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c03117, 4094, (Object) null);
                        c03112 = c03117;
                        if (obj3 == obj) {
                            return obj;
                        }
                        iframe3 = iframe2;
                        iframeResp2 = iframeResp;
                        vdRegex2 = vdRegex;
                        referer6 = url2;
                        body2 = body;
                        iframe4 = referer5;
                        String iframeurl3 = ((NiceResponse) obj3).getText();
                        String name5 = getName();
                        String name6 = getName();
                        ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                        C03122 c03124 = new C03122(iframe4, continuation2);
                        c03112.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                        c03112.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                        c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                        c03112.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                        c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                        c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                        c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                        c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                        c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation5);
                        c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                        c03112.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl3);
                        c03112.label = 4;
                        $result = ExtractorApiKt.newExtractorLink(name5, name6, iframeurl3, infer_type3, c03124, c03112);
                        if ($result == obj) {
                            return obj;
                        }
                        return CollectionsKt.listOf($result);
                    }
                }
                return continuation2;
            case 3:
                Continuation continuation6 = (String) c03112.L$9;
                Continuation continuation7 = (String) c03112.L$8;
                Regex tkRegex3 = (Regex) c03112.L$7;
                vdRegex2 = (Regex) c03112.L$6;
                String iframeHtml2 = (String) c03112.L$5;
                NiceResponse iframeResp3 = (NiceResponse) c03112.L$4;
                FormBody body4 = (FormBody) c03112.L$3;
                String iframe6 = (String) c03112.L$2;
                String referer9 = (String) c03112.L$1;
                String url5 = (String) c03112.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                continuation4 = continuation6;
                continuation5 = continuation7;
                tkRegex2 = tkRegex3;
                iframeHtml = iframeHtml2;
                iframeResp2 = iframeResp3;
                body2 = body4;
                iframe3 = iframe6;
                iframe4 = referer9;
                referer6 = url5;
                obj3 = $result;
                continuation2 = null;
                String iframeurl4 = ((NiceResponse) obj3).getText();
                String name7 = getName();
                String name8 = getName();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                C03122 c03125 = new C03122(iframe4, continuation2);
                c03112.L$0 = SpillingKt.nullOutSpilledVariable(referer6);
                c03112.L$1 = SpillingKt.nullOutSpilledVariable(iframe4);
                c03112.L$2 = SpillingKt.nullOutSpilledVariable(iframe3);
                c03112.L$3 = SpillingKt.nullOutSpilledVariable(body2);
                c03112.L$4 = SpillingKt.nullOutSpilledVariable(iframeResp2);
                c03112.L$5 = SpillingKt.nullOutSpilledVariable(iframeHtml);
                c03112.L$6 = SpillingKt.nullOutSpilledVariable(vdRegex2);
                c03112.L$7 = SpillingKt.nullOutSpilledVariable(tkRegex2);
                c03112.L$8 = SpillingKt.nullOutSpilledVariable(continuation5);
                c03112.L$9 = SpillingKt.nullOutSpilledVariable(continuation4);
                c03112.L$10 = SpillingKt.nullOutSpilledVariable(iframeurl4);
                c03112.label = 4;
                $result = ExtractorApiKt.newExtractorLink(name7, name8, iframeurl4, infer_type4, c03125, c03112);
                if ($result == obj) {
                    return obj;
                }
                return CollectionsKt.listOf($result);
            case 4:
                ResultKt.throwOnFailure($result);
                return CollectionsKt.listOf($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Wootly$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Wootly$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03122 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $referer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03122(String str, Continuation<? super C03122> continuation) {
            super(2, continuation);
            this.$referer = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03122 = new C03122(this.$referer, continuation);
            c03122.L$0 = obj;
            return c03122;
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
