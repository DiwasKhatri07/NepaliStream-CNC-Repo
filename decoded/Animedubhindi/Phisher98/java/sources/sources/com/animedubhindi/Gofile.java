package com.animedubhindi;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Arrays;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animedubhindi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/animedubhindi/Gofile;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "mainApi", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuality", "", "fileName", "Animedubhindi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Gofile extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Gofile";

    @NotNull
    private final String mainUrl = "https://gofile.io";

    @NotNull
    private final String mainApi = "https://api.gofile.io";

    /* JADX INFO: renamed from: com.animedubhindi.Gofile$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Gofile", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {438, 442, 446, 469}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "id", "url", "referer", "subtitleCallback", "callback", "id", "responseText", "json", "token", "url", "referer", "subtitleCallback", "callback", "id", "responseText", "json", "token", "globalJs", "wt", "url", "referer", "subtitleCallback", "callback", "id", "responseText", "json", "token", "globalJs", "wt", "responseTextfile", "fileDataJson", "data", "children", "firstFileId", "fileObj", "link", "fileName", "sizeFormatted", "fileSize"}, nl = {439, 443, 449, 468}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "J$0"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
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

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Gofile.this.getUrl(null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:53:0x02c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:57:0x02eb A[Catch: Exception -> 0x055f, TryCatch #10 {Exception -> 0x055f, blocks: (B:55:0x02cd, B:57:0x02eb, B:59:0x02f2, B:61:0x02fb, B:48:0x023d), top: B:136:0x023d }] */
    /* JADX WARN: Code duplicated, block: B:73:0x03fa A[Catch: Exception -> 0x0535, TRY_ENTER, TryCatch #6 {Exception -> 0x0535, blocks: (B:70:0x03b3, B:73:0x03fa, B:75:0x044b, B:74:0x0422), top: B:128:0x03b3 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0422 A[Catch: Exception -> 0x0535, TryCatch #6 {Exception -> 0x0535, blocks: (B:70:0x03b3, B:73:0x03fa, B:75:0x044b, B:74:0x0422), top: B:128:0x03b3 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0511 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0512  */
    /* JADX WARN: Code duplicated, block: B:92:0x0548 A[ADDED_TO_REGION, REMOVE] */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00111 c00111;
        String url2;
        List groupValues;
        String id;
        String str;
        int i;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj;
        String id2;
        Function1<? super ExtractorLink, Unit> function4;
        String token;
        String id3;
        C00111 c00112;
        JSONObject json;
        Function1<? super ExtractorLink, Unit> function5;
        String responseText;
        Object obj2;
        Object obj3;
        String token2;
        String id4;
        Function1<? super ExtractorLink, Unit> function6;
        String globalJs;
        MatchResult matchResultFind$default;
        List groupValues2;
        String wt;
        String id5;
        char c;
        String responseText2;
        JSONObject json2;
        Function1<? super ExtractorLink, Unit> function7;
        String token3;
        long fileSize;
        long fileSize2;
        String sizeFormatted;
        Function1<? super ExtractorLink, Unit> function8;
        String url3;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00113 = c00111;
        Object $result = c00113.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00113.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    MatchResult matchResultFind$default2 = Regex.find$default(new Regex("/(?:\\?c=|d/)([\\da-zA-Z-]+)"), url, 0, 2, (Object) null);
                    if (matchResultFind$default2 == null || (groupValues = matchResultFind$default2.getGroupValues()) == null || (id = (String) groupValues.get(1)) == null) {
                        try {
                            return Unit.INSTANCE;
                        } catch (Exception e) {
                            e = e;
                            url2 = url;
                        }
                    } else {
                        try {
                            Requests app = MainActivityKt.getApp();
                            String str2 = this.mainApi + "/accounts";
                            c00113.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                            c00113.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                            c00113.L$3 = function2;
                            c00113.L$4 = id;
                            c00113.label = 1;
                            str = "data";
                            i = 2;
                            try {
                                Object objPost$default = Requests.post$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00113, 65534, (Object) null);
                                c00113 = c00113;
                                if (objPost$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url2 = url;
                                referer2 = referer;
                                function3 = function1;
                                obj = objPost$default;
                                id2 = id;
                                function4 = function2;
                                try {
                                    String responseText3 = ((NiceResponse) obj).getText();
                                    JSONObject json3 = new JSONObject(responseText3);
                                    token = json3.getJSONObject(str).getString("token");
                                    Requests app2 = MainActivityKt.getApp();
                                    String str3 = getMainUrl() + "/dist/js/global.js";
                                    c00113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                    c00113.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00113.L$3 = function4;
                                    c00113.L$4 = id2;
                                    c00113.L$5 = SpillingKt.nullOutSpilledVariable(responseText3);
                                    c00113.L$6 = SpillingKt.nullOutSpilledVariable(json3);
                                    c00113.L$7 = token;
                                    c00113.label = i;
                                    id3 = id2;
                                    c00112 = c00113;
                                    json = json3;
                                    function5 = function4;
                                    responseText = responseText3;
                                    try {
                                        obj2 = Requests.get$default(app2, str3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 4094, (Object) null);
                                        c00113 = c00112;
                                        if (obj2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj3 = obj2;
                                        token2 = token;
                                        function4 = function5;
                                        id4 = id3;
                                        globalJs = ((NiceResponse) obj3).getText();
                                        matchResultFind$default = Regex.find$default(new Regex("appdata\\.wt\\s*=\\s*[\"']([^\"']+)[\"']"), globalJs, 0, i, (Object) null);
                                        if (matchResultFind$default != null || (groupValues2 = matchResultFind$default.getGroupValues()) == null || (wt = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null) {
                                            try {
                                                return Unit.INSTANCE;
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        } else {
                                            Requests app3 = MainActivityKt.getApp();
                                            try {
                                                String str4 = this.mainApi + "/contents/" + id4 + "?wt=" + wt;
                                                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + token2));
                                                c00113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                                c00113.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                                c00113.L$3 = function4;
                                                c00113.L$4 = SpillingKt.nullOutSpilledVariable(id4);
                                                c00113.L$5 = SpillingKt.nullOutSpilledVariable(responseText);
                                                c00113.L$6 = SpillingKt.nullOutSpilledVariable(json);
                                                c00113.L$7 = token2;
                                                c00113.L$8 = SpillingKt.nullOutSpilledVariable(globalJs);
                                                c00113.L$9 = SpillingKt.nullOutSpilledVariable(wt);
                                                c00113.label = 3;
                                                id5 = id4;
                                                function5 = function4;
                                                c00112 = c00113;
                                                c = 0;
                                                String token4 = token2;
                                                $result = Requests.get$default(app3, str4, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 4092, (Object) null);
                                                c00113 = c00112;
                                                if ($result == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                responseText2 = wt;
                                                json2 = json;
                                                function7 = function5;
                                                token3 = token4;
                                                try {
                                                    String responseTextfile = ((NiceResponse) $result).getText();
                                                    JSONObject fileDataJson = new JSONObject(responseTextfile);
                                                    JSONObject data = fileDataJson.getJSONObject(str);
                                                    JSONObject children = data.getJSONObject("children");
                                                    String firstFileId = (String) SequencesKt.first(SequencesKt.asSequence(children.keys()));
                                                    JSONObject fileObj = children.getJSONObject(firstFileId);
                                                    String link = fileObj.getString("link");
                                                    String fileName = fileObj.getString("name");
                                                    fileSize = fileObj.getLong("size");
                                                    if (fileSize < 1073741824) {
                                                        fileSize2 = fileSize;
                                                        Object[] objArr = new Object[1];
                                                        objArr[c] = Boxing.boxDouble((fileSize2 / 1024.0d) / 1024.0d);
                                                        sizeFormatted = String.format("%.2f MB", Arrays.copyOf(objArr, 1));
                                                        Intrinsics.checkNotNullExpressionValue(sizeFormatted, "format(...)");
                                                    } else {
                                                        fileSize2 = fileSize;
                                                        Object[] objArr2 = new Object[1];
                                                        objArr2[c] = Boxing.boxDouble(((fileSize2 / 1024.0d) / 1024.0d) / 1024.0d);
                                                        sizeFormatted = String.format("%.2f GB", Arrays.copyOf(objArr2, 1));
                                                        Intrinsics.checkNotNullExpressionValue(sizeFormatted, "format(...)");
                                                    }
                                                    String fileName2 = "Gofile [" + sizeFormatted + ']';
                                                    String sizeFormatted2 = sizeFormatted;
                                                    try {
                                                        C00122 c00122 = new C00122(fileName, token3, null);
                                                        c00113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                                        c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                                        c00113.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                                        c00113.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                                        c00113.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                                                        c00113.L$5 = SpillingKt.nullOutSpilledVariable(responseText);
                                                        c00113.L$6 = SpillingKt.nullOutSpilledVariable(json2);
                                                        c00113.L$7 = SpillingKt.nullOutSpilledVariable(token3);
                                                        c00113.L$8 = SpillingKt.nullOutSpilledVariable(globalJs);
                                                        c00113.L$9 = SpillingKt.nullOutSpilledVariable(responseText2);
                                                        c00113.L$10 = SpillingKt.nullOutSpilledVariable(responseTextfile);
                                                        c00113.L$11 = SpillingKt.nullOutSpilledVariable(fileDataJson);
                                                        c00113.L$12 = SpillingKt.nullOutSpilledVariable(data);
                                                        c00113.L$13 = SpillingKt.nullOutSpilledVariable(children);
                                                        c00113.L$14 = SpillingKt.nullOutSpilledVariable(firstFileId);
                                                        c00113.L$15 = SpillingKt.nullOutSpilledVariable(fileObj);
                                                        c00113.L$16 = SpillingKt.nullOutSpilledVariable(link);
                                                        c00113.L$17 = SpillingKt.nullOutSpilledVariable(fileName);
                                                        c00113.L$18 = SpillingKt.nullOutSpilledVariable(sizeFormatted2);
                                                        c00113.L$19 = function7;
                                                        c00113.J$0 = fileSize2;
                                                        c00113.label = 4;
                                                        $result = ExtractorApiKt.newExtractorLink$default("Gofile", fileName2, link, (ExtractorLinkType) null, c00122, c00113, 8, (Object) null);
                                                        if ($result == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        function8 = function7;
                                                        url3 = url2;
                                                        try {
                                                            function8.invoke($result);
                                                            break;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            url2 = url3;
                                                            Log.INSTANCE.e("Gofile", "Error occurred: " + e.getMessage());
                                                        }
                                                        return Unit.INSTANCE;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                function6 = function4;
                                            }
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    function6 = function4;
                                    Log.INSTANCE.e("Gofile", "Error occurred: " + e.getMessage());
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e9) {
                                e = e9;
                                url2 = url;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            url2 = url;
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    url2 = url;
                }
                Log.INSTANCE.e("Gofile", "Error occurred: " + e.getMessage());
                return Unit.INSTANCE;
            case 1:
                String id6 = (String) c00113.L$4;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00113.L$3;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00113.L$2;
                String referer3 = (String) c00113.L$1;
                String url4 = (String) c00113.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "data";
                    function3 = function10;
                    referer2 = referer3;
                    url2 = url4;
                    i = 2;
                    id2 = id6;
                    function4 = function9;
                    obj = $result;
                    String responseText4 = ((NiceResponse) obj).getText();
                    JSONObject json4 = new JSONObject(responseText4);
                    token = json4.getJSONObject(str).getString("token");
                    Requests app4 = MainActivityKt.getApp();
                    String str5 = getMainUrl() + "/dist/js/global.js";
                    c00113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00113.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00113.L$3 = function4;
                    c00113.L$4 = id2;
                    c00113.L$5 = SpillingKt.nullOutSpilledVariable(responseText4);
                    c00113.L$6 = SpillingKt.nullOutSpilledVariable(json4);
                    c00113.L$7 = token;
                    c00113.label = i;
                    id3 = id2;
                    c00112 = c00113;
                    json = json4;
                    function5 = function4;
                    responseText = responseText4;
                    obj2 = Requests.get$default(app4, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 4094, (Object) null);
                    c00113 = c00112;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj3 = obj2;
                    token2 = token;
                    function4 = function5;
                    id4 = id3;
                    globalJs = ((NiceResponse) obj3).getText();
                    matchResultFind$default = Regex.find$default(new Regex("appdata\\.wt\\s*=\\s*[\"']([^\"']+)[\"']"), globalJs, 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Exception e12) {
                    e = e12;
                    url2 = url4;
                }
                break;
            case 2:
                String token5 = (String) c00113.L$7;
                JSONObject json5 = (JSONObject) c00113.L$6;
                String responseText5 = (String) c00113.L$5;
                String id7 = (String) c00113.L$4;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00113.L$3;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00113.L$2;
                String referer4 = (String) c00113.L$1;
                String url5 = (String) c00113.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "data";
                    json = json5;
                    responseText = responseText5;
                    id4 = id7;
                    function3 = function12;
                    referer2 = referer4;
                    url2 = url5;
                    i = 2;
                    token2 = token5;
                    function4 = function11;
                    obj3 = $result;
                    globalJs = ((NiceResponse) obj3).getText();
                    matchResultFind$default = Regex.find$default(new Regex("appdata\\.wt\\s*=\\s*[\"']([^\"']+)[\"']"), globalJs, 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                    }
                    return Unit.INSTANCE;
                } catch (Exception e13) {
                    e = e13;
                    url2 = url5;
                }
                break;
            case 3:
                String wt2 = (String) c00113.L$9;
                String globalJs2 = (String) c00113.L$8;
                token3 = (String) c00113.L$7;
                json2 = (JSONObject) c00113.L$6;
                String responseText6 = (String) c00113.L$5;
                String id8 = (String) c00113.L$4;
                function7 = (Function1) c00113.L$3;
                Function1<? super SubtitleFile, Unit> function13 = (Function1) c00113.L$2;
                String referer5 = (String) c00113.L$1;
                String url6 = (String) c00113.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = "data";
                    referer2 = referer5;
                    globalJs = globalJs2;
                    url2 = url6;
                    function3 = function13;
                    responseText = responseText6;
                    id5 = id8;
                    c = 0;
                    responseText2 = wt2;
                    String responseTextfile2 = ((NiceResponse) $result).getText();
                    JSONObject fileDataJson2 = new JSONObject(responseTextfile2);
                    JSONObject data2 = fileDataJson2.getJSONObject(str);
                    JSONObject children2 = data2.getJSONObject("children");
                    String firstFileId2 = (String) SequencesKt.first(SequencesKt.asSequence(children2.keys()));
                    JSONObject fileObj2 = children2.getJSONObject(firstFileId2);
                    String link2 = fileObj2.getString("link");
                    String fileName3 = fileObj2.getString("name");
                    fileSize = fileObj2.getLong("size");
                    if (fileSize < 1073741824) {
                        fileSize2 = fileSize;
                        Object[] objArr3 = new Object[1];
                        objArr3[c] = Boxing.boxDouble((fileSize2 / 1024.0d) / 1024.0d);
                        sizeFormatted = String.format("%.2f MB", Arrays.copyOf(objArr3, 1));
                        Intrinsics.checkNotNullExpressionValue(sizeFormatted, "format(...)");
                    } else {
                        fileSize2 = fileSize;
                        Object[] objArr4 = new Object[1];
                        objArr4[c] = Boxing.boxDouble(((fileSize2 / 1024.0d) / 1024.0d) / 1024.0d);
                        sizeFormatted = String.format("%.2f GB", Arrays.copyOf(objArr4, 1));
                        Intrinsics.checkNotNullExpressionValue(sizeFormatted, "format(...)");
                    }
                    String fileName4 = "Gofile [" + sizeFormatted + ']';
                    String sizeFormatted3 = sizeFormatted;
                    C00122 c00123 = new C00122(fileName3, token3, null);
                    c00113.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00113.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00113.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00113.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                    c00113.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                    c00113.L$5 = SpillingKt.nullOutSpilledVariable(responseText);
                    c00113.L$6 = SpillingKt.nullOutSpilledVariable(json2);
                    c00113.L$7 = SpillingKt.nullOutSpilledVariable(token3);
                    c00113.L$8 = SpillingKt.nullOutSpilledVariable(globalJs);
                    c00113.L$9 = SpillingKt.nullOutSpilledVariable(responseText2);
                    c00113.L$10 = SpillingKt.nullOutSpilledVariable(responseTextfile2);
                    c00113.L$11 = SpillingKt.nullOutSpilledVariable(fileDataJson2);
                    c00113.L$12 = SpillingKt.nullOutSpilledVariable(data2);
                    c00113.L$13 = SpillingKt.nullOutSpilledVariable(children2);
                    c00113.L$14 = SpillingKt.nullOutSpilledVariable(firstFileId2);
                    c00113.L$15 = SpillingKt.nullOutSpilledVariable(fileObj2);
                    c00113.L$16 = SpillingKt.nullOutSpilledVariable(link2);
                    c00113.L$17 = SpillingKt.nullOutSpilledVariable(fileName3);
                    c00113.L$18 = SpillingKt.nullOutSpilledVariable(sizeFormatted3);
                    c00113.L$19 = function7;
                    c00113.J$0 = fileSize2;
                    c00113.label = 4;
                    $result = ExtractorApiKt.newExtractorLink$default("Gofile", fileName4, link2, (ExtractorLinkType) null, c00123, c00113, 8, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function8 = function7;
                    url3 = url2;
                    function8.invoke($result);
                    return Unit.INSTANCE;
                } catch (Exception e14) {
                    e = e14;
                    url2 = url6;
                }
                break;
            case 4:
                long j = c00113.J$0;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00113.L$19;
                url3 = (String) c00113.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    function8 = function14;
                    function8.invoke($result);
                    break;
                } catch (Exception e15) {
                    e = e15;
                    url2 = url3;
                    break;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.animedubhindi.Gofile$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.Gofile$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00122 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $token;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00122(String str, String str2, Continuation<? super C00122> continuation) {
            super(2, continuation);
            this.$fileName = str;
            this.$token = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00122 = Gofile.this.new C00122(this.$fileName, this.$token, continuation);
            c00122.L$0 = obj;
            return c00122;
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
                    $this$newExtractorLink.setQuality(Gofile.this.getQuality(this.$fileName));
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Cookie", "accountToken=" + this.$token)));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getQuality(String fileName) {
        List groupValues;
        String str;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), fileName == null ? "" : fileName, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }
}
