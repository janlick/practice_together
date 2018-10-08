package PAL2;
//*******************************************************************
//programer: Yiwei,Theresa
//startTime:2018/09/27
//version:0.1
//Description of the class or method purpose
//purpose:This program is writting for Theresa.For make her familiar with java cod and data structure
//*******************************************************************
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Start {
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(input);
	Acount acount;

	public static void main(String[] argv) {
		Start s = new Start();
		s.login();

		// MainProgramThread mainthread =new MainProgramThread();
		// Thread t=new Thread(mainthread);
		// t.start();
	}

	public void login() {
		Acount ac = null;
		while (ac == null) {
			System.out.println("請輸入你的帳號: 或輸入new 創建新帳號");
			String a = "";
			try {
				a = reader.readLine();
				if (a.equals("new")) {
					System.out.println("創建帳號中 請景輸入妳想創建的帳號");
					a = reader.readLine();
					if (checkAccount(a) != null) {
						System.out.println("此帳號已有人使用 請重新登入 或使用其他新帳號");
						continue;
					} else {
						System.out.println("創建帳號中 請景輸入妳的密碼");
						String p = reader.readLine();
						ac = new Acount(a, p);
						ac.saveAcount();
					}
				} else {
					if (checkAccount(a) == null) {
						System.out.println("此組帳號不存在!!!");

					} else {
						System.out.println(" 請景輸入妳的密碼");
						String p = reader.readLine();
						ac = new Acount(a, p);
						if (p.equals(ac.loadAcount())) {
							System.out.println("Login sucess");
						}
						else 
						{
							System.out.println("Login fail");
							ac=null;
							continue;
						}

					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public File checkAccount(String accountName) {
		File Returnfile = null;
		File dir = new File("./savefile");
		File[] listOfFiles = dir.listFiles();
		
		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().equals(accountName)) {
				System.out.println(file.getName());
				Returnfile = file;
			}
		}
		return Returnfile;
	}

	public class ThreadPool implements Runnable {
		private final LinkedBlockingQueue<Runnable> queue;
		private final List<Thread> threads;
		private boolean shutdown;

		public ThreadPool(int numberOfThreads) {
			queue = new LinkedBlockingQueue<>();
			threads = new ArrayList<>();

			for (int i = 0; i < numberOfThreads; i++) {
				Thread thread = new Thread(this);
				thread.start();
				threads.add(thread);
			}
		}

		public void execute(Runnable task) throws InterruptedException {
			queue.put(task);
		}

		private Runnable consume() throws InterruptedException {
			return queue.take();
		}

		public void run() {
			try {
				System.out.println("thread build");
				while (!shutdown) {
					Runnable task = this.consume();
					// System.out.println("RUNTASK"+task.toString());
					task.run();
				}
			} catch (InterruptedException e) {
			}
			// System.out.println(Thread.currentThread().getName() + " shutdown");
		}

		public void shutdown() {
			shutdown = true;

			threads.forEach((thread) -> {
				thread.interrupt();
			});
		}
	}

}
