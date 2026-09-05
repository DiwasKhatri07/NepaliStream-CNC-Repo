package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: AnimePahe.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimePahe/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1", f = "AnimePahe.kt", i = {0, 1, 1}, l = {544, 332}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "pageUri"}, nl = {545, 333}, s = {"L$0", "L$0", "L$5"}, v = 2)
@SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$generateListOfEpisodes$deferredResults$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,543:1\n81#2,3:544\n85#2,2:574\n93#3,2:547\n63#3:549\n64#3,15:551\n95#3,2:568\n1#4:550\n50#5:566\n43#5:567\n1739#6:570\n1814#6,3:571\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$generateListOfEpisodes$deferredResults$1$1\n*L\n329#1:544,3\n329#1:574,2\n333#1:547,2\n333#1:549\n333#1:551,15\n333#1:568,2\n333#1:550\n333#1:566\n333#1:567\n334#1:570\n334#1:571,3\n*E\n"})
final class AnimePahe$generateListOfEpisodes$deferredResults$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Episode>>, Object> {
    final /* synthetic */ Ref.IntRef $currentEpisode;
    final /* synthetic */ Map<String, MetaEpisode> $metaEpisodes;
    final /* synthetic */ int $page;
    final /* synthetic */ Semaphore $semaphore;
    final /* synthetic */ String $session;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ AnimePahe this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimePahe$generateListOfEpisodes$deferredResults$1$1(Semaphore semaphore, AnimePahe animePahe, String str, int i, Map<String, MetaEpisode> map, Ref.IntRef intRef, Continuation<? super AnimePahe$generateListOfEpisodes$deferredResults$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.this$0 = animePahe;
        this.$session = str;
        this.$page = i;
        this.$metaEpisodes = map;
        this.$currentEpisode = intRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimePahe$generateListOfEpisodes$deferredResults$1$1(this.$semaphore, this.this$0, this.$session, this.$page, this.$metaEpisodes, this.$currentEpisode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Episode>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x00dd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00de  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:34:0x0126  */
    /* JADX WARN: Code duplicated, block: B:46:0x015e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0185  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ac A[Catch: all -> 0x0269, Exception -> 0x026d, TryCatch #0 {Exception -> 0x026d, blocks: (B:73:0x01a8, B:75:0x01ac, B:77:0x01b2, B:78:0x01c9, B:80:0x01cf, B:87:0x01f4), top: B:109:0x01a8 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0254 A[Catch: Exception -> 0x0261, all -> 0x0269, TRY_LEAVE, TryCatch #4 {all -> 0x0269, blocks: (B:73:0x01a8, B:75:0x01ac, B:77:0x01b2, B:78:0x01c9, B:80:0x01cf, B:82:0x01e5, B:87:0x01f4, B:89:0x022a, B:90:0x0247, B:91:0x0254, B:44:0x0158, B:47:0x015f, B:64:0x0187, B:62:0x017e, B:43:0x014e), top: B:115:0x014e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x0266: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
      (r27 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-withPermit-AnimePahe$generateListOfEpisodes$deferredResults$1$1$1' int)])
    , block:B:94:0x0262 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    public final Object invokeSuspend(Object $result) throws Throwable {
        List listEmptyList;
        ?? text;
        Map<String, MetaEpisode> map;
        String str;
        int i;
        Ref.IntRef intRef;
        Semaphore $this$withPermit$iv;
        Semaphore $this$withPermit$iv2;
        AnimePahe animePahe;
        int i2;
        Object objAppGet;
        int i3;
        String str2;
        Object obj;
        Semaphore semaphore;
        Object objDecodeFromString;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        ?? r14;
        AnimePahe.AnimePaheAnimeData pageData;
        int i4;
        Iterable data;
        MetaEpisode meta;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv3 = this.$semaphore;
                        AnimePahe animePahe2 = this.this$0;
                        String str3 = this.$session;
                        int i5 = this.$page;
                        map = this.$metaEpisodes;
                        Ref.IntRef intRef2 = this.$currentEpisode;
                        this.L$0 = $this$withPermit$iv3;
                        this.L$1 = animePahe2;
                        this.L$2 = str3;
                        this.L$3 = map;
                        this.L$4 = intRef2;
                        this.I$0 = i5;
                        this.label = 1;
                        if ($this$withPermit$iv3.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = str3;
                        i = i5;
                        intRef = intRef2;
                        $this$withPermit$iv = $this$withPermit$iv3;
                        $this$withPermit$iv2 = null;
                        animePahe = animePahe2;
                        i2 = 0;
                        String pageUri = animePahe.getMainUrl() + "/api?m=release&id=" + str + "&sort=episode_asc&page=" + i;
                        AnimePahe.Companion companion = AnimePahe.INSTANCE;
                        Map<String, String> headers = AnimePahe.INSTANCE.getHeaders();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = animePahe;
                        this.L$2 = str;
                        this.L$3 = map;
                        this.L$4 = intRef;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(pageUri);
                        this.I$0 = i;
                        this.label = 2;
                        objAppGet = companion.appGet(pageUri, headers, this);
                        if (objAppGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i;
                        str2 = str;
                        try {
                            try {
                                text = ((NiceResponse) objAppGet).getText();
                                AppUtils appUtils = AppUtils.INSTANCE;
                                if (text == 0) {
                                    semaphore = $this$withPermit$iv2;
                                    objDecodeFromString = null;
                                } else {
                                    try {
                                        Result.Companion companion2 = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(AnimePahe.AnimePaheAnimeData.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        break;
                                    } catch (Throwable th) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            semaphore = $this$withPermit$iv2;
                                            objDecodeFromString = null;
                                            pageData = (AnimePahe.AnimePaheAnimeData) objDecodeFromString;
                                            if (pageData != null) {
                                                i4 = i2;
                                                listEmptyList = CollectionsKt.emptyList();
                                            } else {
                                                i4 = i2;
                                                listEmptyList = CollectionsKt.emptyList();
                                            }
                                            $this$withPermit$iv.release();
                                            return listEmptyList;
                                        }
                                    }
                                    if (Result.exceptionOrNull-impl(obj) == null) {
                                        semaphore = $this$withPermit$iv2;
                                        obj2 = null;
                                    } else {
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            semaphore = $this$withPermit$iv2;
                                            obj2 = null;
                                            try {
                                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePahe.AnimePaheAnimeData.class), (List) null, 2, (Object) null));
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                try {
                                                    try {
                                                        Result.Companion companion5 = Result.Companion;
                                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        $this$withPermit$iv.release();
                                                        throw th;
                                                    }
                                                } catch (Exception e2) {
                                                    objDecodeFromString = null;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            semaphore = $this$withPermit$iv2;
                                            obj2 = null;
                                        }
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = obj2;
                                    }
                                    deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            r14 = text;
                                            try {
                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, (String) r14);
                                            } catch (SerializationException e3) {
                                                e$iv$iv = e3;
                                                ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue((String) r14, new TypeReference<AnimePahe.AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                                });
                                            } catch (Throwable th5) {
                                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue((String) r14, new TypeReference<AnimePahe.AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                                });
                                            }
                                        } catch (SerializationException e4) {
                                            e$iv$iv = e4;
                                            r14 = text;
                                        } catch (Throwable th6) {
                                            r14 = text;
                                        }
                                    } else {
                                        r14 = text;
                                    }
                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue((String) r14, new TypeReference<AnimePahe.AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                    });
                                }
                                try {
                                    pageData = (AnimePahe.AnimePaheAnimeData) objDecodeFromString;
                                    try {
                                        if (pageData != null || (data = pageData.getData()) == null) {
                                            i4 = i2;
                                            listEmptyList = CollectionsKt.emptyList();
                                        } else {
                                            Iterable $this$map$iv = data;
                                            int $i$f$map = 0;
                                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            for (Object item$iv$iv : $this$map$iv) {
                                                final AnimePahe.AnimeData episodeData = (AnimePahe.AnimeData) item$iv$iv;
                                                String epNum = String.valueOf(episodeData.getEpisode());
                                                if (map != null) {
                                                    try {
                                                        meta = map.get(epNum);
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        text = i3;
                                                        Log.INSTANCE.e("generateListOfEpisodes", "Error on page " + text + ": " + e.getMessage());
                                                        listEmptyList = CollectionsKt.emptyList();
                                                        $this$withPermit$iv.release();
                                                        return listEmptyList;
                                                    }
                                                } else {
                                                    meta = null;
                                                }
                                                AnimePahe animePahe3 = animePahe;
                                                final MetaEpisode meta2 = meta;
                                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                                String epNum2 = animePahe.getMainUrl();
                                                int i6 = intRef.element;
                                                AnimePahe.AnimePaheAnimeData pageData2 = pageData;
                                                intRef.element = i6 + 1;
                                                Iterable $this$map$iv2 = $this$map$iv;
                                                int $i$f$map2 = $i$f$map;
                                                int i7 = i2;
                                                destination$iv$iv.add(MainAPIKt.newEpisode(animePahe3, appUtils2.toJson(new AnimePahe.LinkLoadData(epNum2, true, i6, i3, str2, episodeData.getSession())), new Function1() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$$ExternalSyntheticLambda0
                                                    public final Object invoke(Object obj3) {
                                                        return AnimePahe$generateListOfEpisodes$deferredResults$1$1.invokeSuspend$lambda$0$0$0(episodeData, meta2, (Episode) obj3);
                                                    }
                                                }));
                                                $this$map$iv = $this$map$iv2;
                                                $i$f$map = $i$f$map2;
                                                i2 = i7;
                                                pageData = pageData2;
                                                break;
                                            }
                                            i4 = i2;
                                            listEmptyList = (List) destination$iv$iv;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        text = i3;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    text = i3;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            text = i3;
                        }
                        $this$withPermit$iv.release();
                        return listEmptyList;
                    case 1:
                        $this$withPermit$iv2 = null;
                        int i8 = this.I$0;
                        Ref.IntRef intRef3 = (Ref.IntRef) this.L$4;
                        Map<String, MetaEpisode> map2 = (Map) this.L$3;
                        String str4 = (String) this.L$2;
                        AnimePahe animePahe4 = (AnimePahe) this.L$1;
                        Semaphore $this$withPermit$iv4 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$withPermit$iv = $this$withPermit$iv4;
                        animePahe = animePahe4;
                        str = str4;
                        map = map2;
                        intRef = intRef3;
                        i = i8;
                        i2 = 0;
                        String pageUri2 = animePahe.getMainUrl() + "/api?m=release&id=" + str + "&sort=episode_asc&page=" + i;
                        AnimePahe.Companion companion6 = AnimePahe.INSTANCE;
                        Map<String, String> headers2 = AnimePahe.INSTANCE.getHeaders();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = animePahe;
                        this.L$2 = str;
                        this.L$3 = map;
                        this.L$4 = intRef;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(pageUri2);
                        this.I$0 = i;
                        this.label = 2;
                        objAppGet = companion6.appGet(pageUri2, headers2, this);
                        if (objAppGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i;
                        str2 = str;
                        text = ((NiceResponse) objAppGet).getText();
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        if (text == 0) {
                            Result.Companion companion7 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(AnimePahe.AnimePaheAnimeData.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            if (Result.exceptionOrNull-impl(obj) == null) {
                                Result.Companion companion8 = Result.Companion;
                                semaphore = $this$withPermit$iv2;
                                obj2 = null;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePahe.AnimePaheAnimeData.class), (List) null, 2, (Object) null));
                            } else {
                                semaphore = $this$withPermit$iv2;
                                obj2 = null;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = obj2;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                r14 = text;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, (String) r14);
                            } else {
                                r14 = text;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue((String) r14, new TypeReference<AnimePahe.AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                            });
                            break;
                        } else {
                            semaphore = $this$withPermit$iv2;
                            objDecodeFromString = null;
                        }
                        pageData = (AnimePahe.AnimePaheAnimeData) objDecodeFromString;
                        if (pageData != null) {
                            i4 = i2;
                            listEmptyList = CollectionsKt.emptyList();
                        } else {
                            i4 = i2;
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        $this$withPermit$iv.release();
                        return listEmptyList;
                    case 2:
                        $this$withPermit$iv2 = null;
                        i2 = 0;
                        int i9 = this.I$0;
                        intRef = (Ref.IntRef) this.L$4;
                        map = (Map) this.L$3;
                        String str5 = (String) this.L$2;
                        animePahe = (AnimePahe) this.L$1;
                        $this$withPermit$iv = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objAppGet = $result;
                        i3 = i9;
                        str2 = str5;
                        text = ((NiceResponse) objAppGet).getText();
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        if (text == 0) {
                            Result.Companion companion9 = Result.Companion;
                            KType kTypeTypeOf3 = Reflection.typeOf(AnimePahe.AnimePaheAnimeData.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                            if (Result.exceptionOrNull-impl(obj) == null) {
                                Result.Companion companion10 = Result.Companion;
                                semaphore = $this$withPermit$iv2;
                                obj2 = null;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePahe.AnimePaheAnimeData.class), (List) null, 2, (Object) null));
                            } else {
                                semaphore = $this$withPermit$iv2;
                                obj2 = null;
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = obj2;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                r14 = text;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, (String) r14);
                            } else {
                                r14 = text;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv5.readValue((String) r14, new TypeReference<AnimePahe.AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$deferredResults$1$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                            });
                            break;
                        } else {
                            semaphore = $this$withPermit$iv2;
                            objDecodeFromString = null;
                        }
                        pageData = (AnimePahe.AnimePaheAnimeData) objDecodeFromString;
                        if (pageData != null) {
                            i4 = i2;
                            listEmptyList = CollectionsKt.emptyList();
                        } else {
                            i4 = i2;
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        $this$withPermit$iv.release();
                        return listEmptyList;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0$0(AnimePahe.AnimeData $episodeData, MetaEpisode $meta, Episode $this$newEpisode) {
        String strGenerateListOfEpisodes$getEpisodeTitle;
        Map<String, String> title;
        Map<String, String> title2;
        String snapshot;
        Map<String, String> title3;
        MainAPIKt.addDate$default($this$newEpisode, $episodeData.getCreated_at(), (String) null, 2, (Object) null);
        if ($meta == null || (title3 = $meta.getTitle()) == null || (strGenerateListOfEpisodes$getEpisodeTitle = title3.get("en")) == null) {
            strGenerateListOfEpisodes$getEpisodeTitle = ($meta == null || (title2 = $meta.getTitle()) == null) ? null : title2.get("x-jat");
            if (strGenerateListOfEpisodes$getEpisodeTitle == null) {
                strGenerateListOfEpisodes$getEpisodeTitle = ($meta == null || (title = $meta.getTitle()) == null) ? null : title.get("ja");
                if (strGenerateListOfEpisodes$getEpisodeTitle == null) {
                    strGenerateListOfEpisodes$getEpisodeTitle = AnimePahe.generateListOfEpisodes$getEpisodeTitle($episodeData);
                }
            }
        }
        $this$newEpisode.setName(strGenerateListOfEpisodes$getEpisodeTitle);
        if ($meta == null || (snapshot = $meta.getImage()) == null) {
            snapshot = $episodeData.getSnapshot();
        }
        $this$newEpisode.setPosterUrl(snapshot);
        $this$newEpisode.setDescription($meta != null ? $meta.getOverview() : null);
        $this$newEpisode.setScore(Score.Companion.from10($meta != null ? $meta.getRating() : null));
        $this$newEpisode.setRunTime($meta != null ? $meta.getRuntime() : null);
        return Unit.INSTANCE;
    }
}
