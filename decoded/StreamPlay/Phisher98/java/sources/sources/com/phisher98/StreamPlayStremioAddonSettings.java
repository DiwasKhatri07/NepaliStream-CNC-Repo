package com.phisher98;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J}\u0010\r\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f0\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00110\u000f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StreamPlayStremioAddonSettings;", "", "<init>", "()V", "PREF_KEY_LINKS", "", "getStremioAddons", "", "Lcom/phisher98/StreamPlayStremioAddon;", "sharedPref", "Landroid/content/SharedPreferences;", "stremioAddonKey", "name", "getDynamicStremioMap", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "imdbId", "season", "", "episode", "subtitleCallback", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonSettings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,239:1\n1#2:240\n1401#3,2:241\n1358#4,2:243\n1435#4,4:245\n*S KotlinDebug\n*F\n+ 1 StreamPlayStremioAddon.kt\ncom/phisher98/StreamPlayStremioAddonSettings\n*L\n52#1:241,2\n81#1:243,2\n81#1:245,4\n*E\n"})
public final class StreamPlayStremioAddonSettings {

    @NotNull
    public static final StreamPlayStremioAddonSettings INSTANCE = new StreamPlayStremioAddonSettings();

    @NotNull
    public static final String PREF_KEY_LINKS = "streamplay_stremio_addon_saved_links";

    private StreamPlayStremioAddonSettings() {
    }

    @NotNull
    public final List<StreamPlayStremioAddon> getStremioAddons(@Nullable SharedPreferences sharedPref) {
        String json;
        JSONArray arr;
        StreamPlayStremioAddonType streamPlayStremioAddonType;
        StreamPlayStremioAddonType streamPlayStremioAddonType2;
        if (sharedPref == null || (json = sharedPref.getString(PREF_KEY_LINKS, null)) == null) {
            return CollectionsKt.emptyList();
        }
        List list = new ArrayList();
        try {
            JSONArray arr2 = new JSONArray(json);
            int i = 0;
            int length = arr2.length();
            while (i < length) {
                JSONObject obj = arr2.getJSONObject(i);
                String link = StringsKt.trim(obj.optString("link", "")).toString();
                int i2 = 0;
                if (link.length() == 0) {
                    arr = arr2;
                } else {
                    long jOptLong = obj.optLong("id", System.currentTimeMillis());
                    String strOptString = obj.optString("name", link);
                    if (StringsKt.isBlank(strOptString)) {
                        strOptString = link;
                    }
                    String str = strOptString;
                    String strTrimEnd = StringsKt.trimEnd(StreamPlayUtilsKt.fixSourceUrl(link), new char[]{'/'});
                    StreamPlayStremioAddonType[] streamPlayStremioAddonTypeArrValues = StreamPlayStremioAddonType.values();
                    int length2 = streamPlayStremioAddonTypeArrValues.length;
                    while (true) {
                        if (i2 < length2) {
                            streamPlayStremioAddonType = streamPlayStremioAddonTypeArrValues[i2];
                            arr = arr2;
                            if (StringsKt.equals(streamPlayStremioAddonType.name(), obj.optString("type", "HTTPS"), true)) {
                                break;
                            }
                            i2++;
                            arr2 = arr;
                        } else {
                            arr = arr2;
                            streamPlayStremioAddonType = null;
                            break;
                        }
                    }
                    if (streamPlayStremioAddonType != null) {
                        streamPlayStremioAddonType2 = streamPlayStremioAddonType;
                    } else {
                        streamPlayStremioAddonType2 = StreamPlayStremioAddonType.HTTPS;
                    }
                    list.add(new StreamPlayStremioAddon(jOptLong, str, strTrimEnd, streamPlayStremioAddonType2));
                }
                i++;
                arr2 = arr;
            }
            return list;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    @NotNull
    public final String stremioAddonKey(@NotNull String name) {
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strTrim = StringsKt.trim(new Regex("[^a-z0-9]+").replace(lowerCase, "_"), new char[]{'_'});
        if (StringsKt.isBlank(strTrim)) {
            strTrim = "addon";
        }
        String key = strTrim;
        return "stremio_" + key;
    }

    @NotNull
    public final Map<String, Function1<Continuation<? super Unit>, Object>> getDynamicStremioMap(@Nullable SharedPreferences sharedPref, @Nullable String imdbId, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super SubtitleFile, Unit> subtitleCallback, @NotNull Function1<? super ExtractorLink, Unit> callback) {
        Iterable $this$associate$iv = getStremioAddons(sharedPref);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            StreamPlayStremioAddon addon = (StreamPlayStremioAddon) element$iv$iv;
            String key = INSTANCE.stremioAddonKey(addon.getName());
            Pair pair = TuplesKt.to(key, new StreamPlayStremioAddonSettings$getDynamicStremioMap$1$1(addon, imdbId, season, episode, subtitleCallback, callback, null));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
            $this$associate$iv = $this$associate$iv;
        }
        return destination$iv$iv;
    }
}
