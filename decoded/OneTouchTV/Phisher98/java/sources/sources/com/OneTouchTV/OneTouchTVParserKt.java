package com.OneTouchTV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/OneTouchTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¨\u0006\u000b"}, d2 = {"parseSourcesAndTracks", "Lkotlin/Pair;", "", "Lcom/OneTouchTV/SourceItem;", "Lcom/OneTouchTV/TrackItem;", "decryptedJson", "", "subtitleCallback", "Lkotlin/Function1;", "", "extractorCallback", "OneTouchTV"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class OneTouchTVParserKt {
    public static /* synthetic */ Pair parseSourcesAndTracks$default(String str, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.OneTouchTV.OneTouchTVParserKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function2 = new Function1() { // from class: com.OneTouchTV.OneTouchTVParserKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        return parseSourcesAndTracks(str, function1, function2);
    }

    @NotNull
    public static final Pair<List<SourceItem>, List<TrackItem>> parseSourcesAndTracks(@NotNull String decryptedJson, @NotNull Function1<? super TrackItem, Unit> function1, @NotNull Function1<? super SourceItem, Unit> function2) {
        JSONArray tracksArray;
        List sourcesList = new ArrayList();
        List tracksList = new ArrayList();
        JSONObject root = new JSONObject(decryptedJson);
        JSONObject result = root.has("result") ? root.optJSONObject("result") : root;
        JSONArray sourcesArray = result != null ? result.optJSONArray("sources") : null;
        if (sourcesArray != null) {
            int i = 0;
            int length = sourcesArray.length();
            while (i < length) {
                JSONObject s = sourcesArray.optJSONObject(i);
                if (s != null) {
                    Map headersMap = new LinkedHashMap();
                    JSONObject headersObj = s.optJSONObject("headers");
                    if (headersObj != null) {
                        Iterator<String> itKeys = headersObj.keys();
                        while (itKeys.hasNext()) {
                            String k = itKeys.next();
                            String v = headersObj.optString(k, "");
                            headersMap.put(k, v);
                        }
                    }
                    SourceItem sourceItem = new SourceItem(s.optString("type", ""), s.optString("contentId", ""), s.optString("id", ""), s.optString("name", ""), s.optString("quality", ""), s.optString("url", ""), headersMap);
                    sourcesList.add(sourceItem);
                    function2.invoke(sourceItem);
                }
                i++;
                root = root;
            }
        }
        if (result == null || (tracksArray = result.optJSONArray("track")) == null) {
            tracksArray = result != null ? result.optJSONArray("tracks") : null;
        }
        if (tracksArray != null) {
            int length2 = tracksArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject t = tracksArray.optJSONObject(i2);
                if (t != null) {
                    TrackItem trackItem = new TrackItem(t.optString("file", ""), t.optString("name", ""), t.optBoolean("default", false), t.optString("kind", ""), t.optString("format", ""));
                    tracksList.add(trackItem);
                    function1.invoke(trackItem);
                }
            }
        }
        return new Pair<>(sourcesList, tracksList);
    }
}
