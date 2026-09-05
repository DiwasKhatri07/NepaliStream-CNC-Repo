package com.Animekhor;

import com.lagradost.cloudstream3.extractors.Dailymotion;
import com.lagradost.cloudstream3.extractors.EmturbovidExtractor;
import com.lagradost.cloudstream3.extractors.Mp4Upload;
import com.lagradost.cloudstream3.plugins.BasePlugin;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimekhorProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animekhor/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016Ê\u0001\u0002\b\u0007¨\u0006\u0006"}, d2 = {"Lcom/Animekhor/AnimenosubProvider;", "Lcom/lagradost/cloudstream3/plugins/BasePlugin;", "<init>", "()V", "load", "", "Animekhor", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnimenosubProvider extends BasePlugin {
    public void load() {
        registerMainAPI(new Animekhor());
        registerMainAPI(new Donghuaword());
        registerExtractorAPI((ExtractorApi) new embedwish());
        registerExtractorAPI((ExtractorApi) new Filelions());
        registerExtractorAPI((ExtractorApi) new VidHidePro5());
        registerExtractorAPI((ExtractorApi) new Swhoi());
        registerExtractorAPI((ExtractorApi) new EmturbovidExtractor());
        registerExtractorAPI((ExtractorApi) new Dailymotion());
        registerExtractorAPI(new Rumble());
        registerExtractorAPI((ExtractorApi) new Mp4Upload());
        registerExtractorAPI(new PlayerDonghuaworld());
        registerExtractorAPI((ExtractorApi) new P2pstream());
        registerExtractorAPI(new Donghuaplanet());
    }
}
