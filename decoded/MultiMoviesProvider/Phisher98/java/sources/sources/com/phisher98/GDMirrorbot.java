package com.phisher98;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MultiMoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/phisher98/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractSidsAndHost", "Lkotlin/Pair;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "MultiMoviesProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,379:1\n2068#2:380\n2068#2,2:382\n2069#2:384\n1795#2,10:385\n2068#2:395\n2069#2:397\n1805#2:398\n777#2:399\n873#2,2:400\n1#3:381\n1#3:396\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n*L\n100#1:380\n146#1:382,2\n100#1:384\n228#1:385,10\n228#1:395\n228#1:397\n228#1:398\n231#1:399\n231#1:400,2\n228#1:396\n*E\n"})
public class GDMirrorbot extends ExtractorApi {

    @NotNull
    private String name = "GDMirrorbot";

    @NotNull
    private String mainUrl = "https://gdmirrorbot.nl";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.GDMirrorbot$extractSidsAndHost$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {183, 186, 218}, m = "extractSidsAndHost", n = {"url", "sid", "url", "url", "pageText", "finalId", "myKey", "idType", "baseUrl", "host", "apiUrl"}, nl = {184, 189, 221}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDMirrorbot.this.extractSidsAndHost(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.GDMirrorbot$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {93, 104, 158, 161, 164}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "sids", "host", "$this$forEach$iv", "element$iv", "sid", "$this", "url", "referer", "subtitleCallback", "callback", "sids", "host", "$this$forEach$iv", "element$iv", "sid", "root", "siteUrls", "siteFriendlyNames", "$this$forEach$iv", "decodedMresult", "responseText", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sids", "host", "$this$forEach$iv", "element$iv", "sid", "root", "siteUrls", "siteFriendlyNames", "$this$forEach$iv", "decodedMresult", "responseText", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sids", "host", "$this$forEach$iv", "element$iv", "sid", "root", "siteUrls", "siteFriendlyNames", "$this$forEach$iv", "decodedMresult", "responseText", "element$iv", "key", "path", "fullUrl", "friendlyName", "base"}, nl = {95, 111, 161, 164, 167}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDMirrorbot.getUrl$suspendImpl(GDMirrorbot.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:238:0x09a7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.GDMirrorbot r44, java.lang.String r45, java.lang.String r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, kotlin.coroutines.Continuation<? super kotlin.Unit> r49) {
        /*
            Method dump skipped, instruction units count: 3272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.GDMirrorbot.getUrl$suspendImpl(com.phisher98.GDMirrorbot, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0378  */
    /* JADX WARN: Code duplicated, block: B:102:0x037c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0428  */
    /* JADX WARN: Code duplicated, block: B:135:0x043c A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0150  */
    /* JADX WARN: Code duplicated, block: B:37:0x0174  */
    /* JADX WARN: Code duplicated, block: B:45:0x0199  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:63:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:67:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object extractSidsAndHost(String url, Continuation<? super Pair<? extends List<String>, String>> continuation) {
        C00001 c00001;
        Object obj;
        String url2;
        GDMirrorbot gDMirrorbot;
        String sid;
        String pageText;
        MatchResult matchResultFind$default;
        int i;
        String str;
        String finalId;
        MatchResult matchResultFind$default2;
        String str2;
        MatchResult matchResultFind$default3;
        String idType;
        MatchResult matchResultFind$default4;
        MatchResult matchResultFind$default5;
        String str3;
        List groupValues;
        String baseUrl;
        GDMirrorbot gDMirrorbot2;
        String baseUrl2;
        String host;
        JsonElement jsonElement;
        String pageText2;
        String host2;
        String finalId2;
        String apiUrl;
        String url3;
        String baseUrl3;
        String myKey;
        String apiUrl2;
        String season;
        List groupValues2;
        String str4;
        List groupValues3;
        List groupValues4;
        String it;
        List groupValues5;
        List groupValues6;
        List groupValues7;
        JsonElement it2;
        JsonObject json;
        List it3;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(url, "key=", false, 2, (Object) null)) {
                    String sid2 = StringsKt.substringAfterLast$default(url, "embed/", (String) null, 2, (Object) null);
                    Requests app = MainActivityKt.getApp();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00002.L$1 = sid2;
                    c00002.L$2 = this;
                    c00002.label = 1;
                    $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gDMirrorbot = this;
                    sid = sid2;
                    return new Pair(CollectionsKt.listOf(sid), gDMirrorbot.getBaseUrl(((NiceResponse) $result).getUrl()));
                }
                obj = coroutine_suspended;
                Requests app2 = MainActivityKt.getApp();
                c00002.L$0 = url;
                c00002.label = 2;
                $result = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                pageText = ((NiceResponse) $result).getText();
                matchResultFind$default = Regex.find$default(new Regex("FinalID\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues7 = matchResultFind$default.getGroupValues()) == null) {
                    i = 1;
                    str = null;
                } else {
                    i = 1;
                    str = (String) groupValues7.get(1);
                }
                finalId = str;
                matchResultFind$default2 = Regex.find$default(new Regex("myKey\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default2 != null || (groupValues6 = matchResultFind$default2.getGroupValues()) == null) {
                    str2 = null;
                } else {
                    str2 = (String) groupValues6.get(i);
                }
                String myKey2 = str2;
                matchResultFind$default3 = Regex.find$default(new Regex("idType\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default3 != null || (groupValues5 = matchResultFind$default3.getGroupValues()) == null || (idType = (String) groupValues5.get(i)) == null) {
                    idType = "imdbid";
                }
                matchResultFind$default4 = Regex.find$default(new Regex("let\\s+baseUrl\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default4 != null || (groupValues4 = matchResultFind$default4.getGroupValues()) == null || (it = (String) groupValues4.get(i)) == null) {
                    matchResultFind$default5 = Regex.find$default(new Regex("player_base\\s*=\\s*[\"']([^\"']+)[\"']"), pageText, 0, 2, (Object) null);
                    if (matchResultFind$default5 != null || (groupValues = matchResultFind$default5.getGroupValues()) == null) {
                        str3 = null;
                    } else {
                        str3 = (String) groupValues.get(i);
                    }
                } else {
                    str3 = StringsKt.startsWith$default(it, "http", false, 2, (Object) null) ? it : null;
                    if (str3 == null) {
                        matchResultFind$default5 = Regex.find$default(new Regex("player_base\\s*=\\s*[\"']([^\"']+)[\"']"), pageText, 0, 2, (Object) null);
                        if (matchResultFind$default5 != null) {
                            str3 = null;
                        } else {
                            str3 = null;
                        }
                    }
                }
                baseUrl = str3;
                if (baseUrl != null) {
                    gDMirrorbot2 = this;
                    baseUrl2 = gDMirrorbot2.getBaseUrl(baseUrl);
                } else {
                    gDMirrorbot2 = this;
                    baseUrl2 = null;
                }
                host = baseUrl2;
                if (finalId != null || myKey2 == null) {
                    String url4 = url2;
                    jsonElement = null;
                    pageText2 = pageText;
                    host2 = host;
                    finalId2 = url4;
                } else {
                    if (StringsKt.contains$default(url2, "/tv/", false, 2, (Object) null)) {
                        MatchResult matchResultFind$default6 = Regex.find$default(new Regex("/tv/\\d+/(\\d+)/"), url2, 0, 2, (Object) null);
                        String episode = "1";
                        if (matchResultFind$default6 == null || (groupValues3 = matchResultFind$default6.getGroupValues()) == null || (season = (String) groupValues3.get(i)) == null) {
                            season = "1";
                        }
                        MatchResult matchResultFind$default7 = Regex.find$default(new Regex("/tv/\\d+/\\d+/(\\d+)"), url2, 0, 2, (Object) null);
                        if (matchResultFind$default7 != null && (groupValues2 = matchResultFind$default7.getGroupValues()) != null && (str4 = (String) groupValues2.get(1)) != null) {
                            episode = str4;
                        }
                        apiUrl = gDMirrorbot2.getMainUrl() + "/myseriesapi?tmdbid=" + finalId + "&season=" + season + "&epname=" + episode + "&key=" + myKey2;
                    } else {
                        apiUrl = gDMirrorbot2.getMainUrl() + "/mymovieapi?" + idType + '=' + finalId + "&key=" + myKey2;
                    }
                    Requests app3 = MainActivityKt.getApp();
                    c00002.L$0 = url2;
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(pageText);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(finalId);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(myKey2);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(idType);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(baseUrl);
                    c00002.L$6 = host;
                    c00002.L$7 = SpillingKt.nullOutSpilledVariable(apiUrl);
                    c00002.label = 3;
                    String idType2 = apiUrl;
                    url3 = url2;
                    jsonElement = null;
                    Object obj2 = Requests.get$default(app3, apiUrl, (Map) null, idType2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4090, (Object) null);
                    if (obj2 == obj) {
                        return obj;
                    }
                    $result = obj2;
                    baseUrl3 = baseUrl;
                    myKey = myKey2;
                    apiUrl2 = host;
                    pageText2 = ((NiceResponse) $result).getText();
                    host2 = apiUrl2;
                    finalId2 = url3;
                }
                it2 = JsonParser.parseString(pageText2);
                if (!it2.isJsonObject()) {
                    it2 = jsonElement;
                }
                if (it2 != null || (json = it2.getAsJsonObject()) == null) {
                    return null;
                }
                JsonElement jsonElement2 = json.get("data");
                JsonElement asJsonArray = jsonElement2 != null ? jsonElement2.getAsJsonArray() : jsonElement;
                if (asJsonArray != null) {
                    Iterable $this$mapNotNull$iv = (Iterable) asJsonArray;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        JsonElement jsonElement3 = ((JsonElement) element$iv$iv$iv).getAsJsonObject().get("fileslug");
                        String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                        if (asString != null) {
                            destination$iv$iv.add(asString);
                        }
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        if (!StringsKt.isBlank((String) element$iv$iv)) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                    }
                    it3 = (List) destination$iv$iv2;
                    if (it3.isEmpty()) {
                        it3 = null;
                    }
                    if (it3 == null) {
                        it3 = CollectionsKt.listOf(StringsKt.substringAfterLast$default(finalId2, "/", (String) null, 2, (Object) null));
                    }
                } else {
                    it3 = CollectionsKt.listOf(StringsKt.substringAfterLast$default(finalId2, "/", (String) null, 2, (Object) null));
                }
                return new Pair(it3, host2);
            case 1:
                gDMirrorbot = (GDMirrorbot) c00002.L$2;
                sid = (String) c00002.L$1;
                ResultKt.throwOnFailure($result);
                return new Pair(CollectionsKt.listOf(sid), gDMirrorbot.getBaseUrl(((NiceResponse) $result).getUrl()));
            case 2:
                url2 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                pageText = ((NiceResponse) $result).getText();
                matchResultFind$default = Regex.find$default(new Regex("FinalID\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    i = 1;
                    str = null;
                } else {
                    i = 1;
                    str = null;
                }
                finalId = str;
                matchResultFind$default2 = Regex.find$default(new Regex("myKey\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    str2 = null;
                } else {
                    str2 = null;
                }
                String myKey3 = str2;
                matchResultFind$default3 = Regex.find$default(new Regex("idType\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default3 != null) {
                    idType = "imdbid";
                } else {
                    idType = "imdbid";
                }
                matchResultFind$default4 = Regex.find$default(new Regex("let\\s+baseUrl\\s*=\\s*\"([^\"]+)\""), pageText, 0, 2, (Object) null);
                if (matchResultFind$default4 != null) {
                    matchResultFind$default5 = Regex.find$default(new Regex("player_base\\s*=\\s*[\"']([^\"']+)[\"']"), pageText, 0, 2, (Object) null);
                    if (matchResultFind$default5 != null) {
                        str3 = null;
                    } else {
                        str3 = null;
                    }
                } else {
                    matchResultFind$default5 = Regex.find$default(new Regex("player_base\\s*=\\s*[\"']([^\"']+)[\"']"), pageText, 0, 2, (Object) null);
                    if (matchResultFind$default5 != null) {
                        str3 = null;
                    } else {
                        str3 = null;
                    }
                }
                baseUrl = str3;
                if (baseUrl != null) {
                    gDMirrorbot2 = this;
                    baseUrl2 = gDMirrorbot2.getBaseUrl(baseUrl);
                } else {
                    gDMirrorbot2 = this;
                    baseUrl2 = null;
                }
                host = baseUrl2;
                if (finalId != null) {
                }
                String url5 = url2;
                jsonElement = null;
                pageText2 = pageText;
                host2 = host;
                finalId2 = url5;
                it2 = JsonParser.parseString(pageText2);
                if (!it2.isJsonObject()) {
                    it2 = jsonElement;
                }
                if (it2 != null) {
                    return null;
                }
                return null;
            case 3:
                apiUrl2 = (String) c00002.L$6;
                baseUrl3 = (String) c00002.L$5;
                myKey = (String) c00002.L$3;
                String url6 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                url3 = url6;
                jsonElement = null;
                pageText2 = ((NiceResponse) $result).getText();
                host2 = apiUrl2;
                finalId2 = url3;
                it2 = JsonParser.parseString(pageText2);
                if (!it2.isJsonObject()) {
                    it2 = jsonElement;
                }
                if (it2 != null) {
                    return null;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
